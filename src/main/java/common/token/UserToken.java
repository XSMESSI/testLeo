package common.token;

/**
 * @Description
 * @Author XuShen
 * @Date 2022/5/25 9:57
 */
public class UserToken {
    private static final long serialVersionUID = 1L;

    public UserToken(String username, String userId, String name) {
        this.userId = userId;
        this.username = username;
        this.name = name;
    }

    public UserToken(String username, String userId, String name, String deptId, String applicationId) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.deptId = deptId;
        this.applicationId = applicationId;
    }

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 归属机构ID
     */
    private String deptId;

    /**
     * 应用ID
     */
    private String applicationId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", deptId='" + deptId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                '}';
    }
}

