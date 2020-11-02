package Test0818;

import Test0818.home.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThinkArrayObj {
    public static void main(String[] args) {
        User[] users = {new User("cater",101),new User("justin",102)};
        //写入新文件  
        writeObjectsToFile(users,args[0]);

        try
        {
            //读取文件数据  
            users = readObjectsFromFile(args[0]);
            //显示读回的对象  
            for(User user : users)
            {
                System.out.printf("%s\t%d%n",user.getName(),user.getNumber());
            }
            System.out.println();

            users = new User[2];
            users[0] = new User("momor",103);
            users[1] = new User("becky",104);

            //附加新对象至文件  
            appendObjectsToFile(users,args[0]);

            //读取文件数据  
            users = readObjectsFromFile(args[0]);
            //显示读回的对象  
            for(User user : users)
            {
                System.out.printf("%s\t%d%n",user.getName(),user.getNumber());
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("没有指定文件名");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //将指定的对象写入至指定的文件  
    public static void writeObjectsToFile(Object[] objs,String filename)
    {
        File file = new File(filename);

        try
        {
            ObjectOutputStream objOutputStream =
                    new ObjectOutputStream(new FileOutputStream(file));

            for(Object obj : objs)
            {
                //将对象写入文件  
                objOutputStream.writeObject(obj);
            }

            //关闭流  
            objOutputStream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    //将指定文件中的对象数据读回  
    public static User[] readObjectsFromFile(String filename) throws FileNotFoundException
    {
        File file = new File(filename);

        //如果文件不存在就抛出异常  
        if(!file.exists())
            throw new FileNotFoundException();

        //使用List先存储读回的对象  
        List<User> list = new ArrayList<User>();

        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);

            while(fileInputStream.available()>0)
            {
                list.add((User)objInputStream.readObject());
            }
            objInputStream.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        User[] users = new User[list.size()];
        return list.toArray(users);
    }

    //将对象附加至指定的文件之后  
    public static void appendObjectsToFile(Object[] objs,String filename) throws FileNotFoundException
    {
        File file = new File(filename);

        //如果文件不存在，则抛出异常  
        if(!file.exists())
            throw new FileNotFoundException();

        try
        {
            //附加模式  
            ObjectOutputStream objOutputStream =
                    new ObjectOutputStream(new FileOutputStream(file,true))
                    {
                        //如果要附加对象至文件后，必须重新定义这个方法  
                        protected void writeStreamHeader() throws IOException {}
                    };

            for(Object obj : objs)
            {
                //将对象写入文件  
                objOutputStream.writeObject(obj);
            }
            objOutputStream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
