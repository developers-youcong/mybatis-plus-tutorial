package com.blog.tutorial07.shiro.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.tutorial07.shiro.entity.Usermeta;
import com.blog.tutorial07.shiro.entity.Users;
import com.blog.tutorial07.shiro.service.UsermetaService;
import com.blog.tutorial07.shiro.service.UsersService;
import com.blog.tutorial07.shiro.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description Shiro权限匹配和账号密码匹配
 * @Author Sans
 * @CreateTime 2019/6/15 11:27
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UsersService sysUserService;

    @Autowired
    private UsermetaService sysRoleService;


    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     *
     * @Author Sans
     * @CreateTime 2019/6/12 11:44
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户ID
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Users user = (Users) principalCollection.getPrimaryPrincipal();
        Long userId = user.getId();

        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();

        QueryWrapper<Usermeta> roleWrapper = new QueryWrapper<>();
        roleWrapper.eq("user_id", userId);
        roleWrapper.eq("meta_key", "wp_user_level");
        List<Usermeta> roleList = sysRoleService.list(roleWrapper);
        for (Usermeta role : roleList) {
            rolesSet.add(role.getMetaValue());
        }

        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     *
     * @Author Sans
     * @CreateTime 2019/6/12 12:36
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_login", username);
        Users user = sysUserService.getOne(wrapper);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if (user.getUserStatus() == null || user.getUserStatus().equals("1")) {
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getUserPass(),                    //密码
                ByteSource.Util.bytes(user.getUserActivationKey()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username, true);
        return authenticationInfo;
    }
}
