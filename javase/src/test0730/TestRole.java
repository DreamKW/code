package test0730;

public class TestRole {
    public static void main(String[] args) {
        if("管理员".equals(Role.MANAGE)){
            System.out.println(Role.MANAGE);
            System.out.println("是管理员");
        }
        if("管理员".equals(RoleEnum.管理员.toString())){
            System.out.println("确实是");
        }

    }
}
