package com.etc.flower.controller;

import com.etc.flower.entity.Address;
import com.etc.flower.entity.Flower;
import com.etc.flower.entity.ShopCar;
import com.etc.flower.entity.Tuser;
import com.etc.flower.service.UserService;
import com.etc.flower.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlowerAction {
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){

        //        清除cookie
        Cookie[] cookies =   request.getCookies();
        if (cookies != null){
//                查住存储的user 信息
            for (Cookie cookie:
                    cookies ) {
                if ("usercookie".equals(cookie.getName())){
//                    清除cookie
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
//      request.getSession().removeAttribute("tuser");
        request.getSession().invalidate();
//        request.getRequestDispatcher("ShowFlowerServlet").forward(request,response);
//        return "forward:show.action";
//        重定向
        return "redirect:show.action";
    }


    @RequestMapping("/go")
    public String goForward(String go ){
       return go;
    }

//    结算
    @RequestMapping("/checkout")
    public String checkout (HttpServletRequest request){
        HttpSession session = request.getSession();
        Tuser tuser = (Tuser)session.getAttribute("tuser");
//        在 SubmitCarServlet 通过 session 存储 sum countMap sumMap
        Double sum  =(Double)session.getAttribute("sum");
//        怎样获取select value 中的值
        String addressid = request.getParameter("address");
        Map<String,Integer> countMap = (Map<String,Integer>) session.getAttribute("countMap");
        Map<String,Double> sumMap = (Map<String,Double>) session.getAttribute("sumMap");
        String ids[] = (String[]) session.getAttribute("idss");
        UserService userService = new UserServiceImpl();
        try {
            userService.pay(tuser,sum,countMap,sumMap,ids,addressid);
//            request.getRequestDispatcher("CheckoutToCarServlet").forward(request,response);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:show.action?result=结算成功&name=rose";
    }

//    提交购物车信息
    @RequestMapping("/subCar")
    public String subCar(HttpServletRequest request){
        String result = "";
        HttpSession session = request.getSession();
//        request.getParameter("shoppingcartto");
        String[] ids = null;
//        if ( !"shoppingcart".equals(request.getParameter("shoppingcartto"))){
//            ids = (String[]) request.getSession().getAttribute("idss");
//        }else {
//           ids = request.getParameterValues("choose");
//            session.setAttribute("idss",ids);
//        }


        if ("shoppingcart".equals(request.getParameter("shcart"))){
            ids = request.getParameterValues("choose");
            session.setAttribute("idss",ids);
        }else {
            ids = (String[]) request.getSession().getAttribute("idss");
        }

        double sum = 0.0;
        //        定义鲜花数量的Map
        Map<String,Integer> cMap = new HashMap<>();
        Map<String,Double> sumMap = new HashMap<>();


//        根据ID值获取到对应的总价
        if ("shoppingcart".equals(request.getParameter("shcart"))){
            for (String id :
                    ids) {
                String sumi = request.getParameter("sum" + id);
//                得到每一种鲜花的购买数量
                String count = request.getParameter("count"+id);
                int c = 0;
                if (count != null && !"".equals(count)){
                    c = Integer.parseInt(count);
                }
                cMap.put(id,c);
                double sumii =0.0;
                if (sumi != null && !sumi.equals("")){
                    sumii = Double.parseDouble(sumi);
                }
//                得到每一种鲜花 以及对应的支付金额
                sumMap.put(id,sumii);
                sum += sumii;
            }
            session.setAttribute("sum",sum);
            session.setAttribute("countMap",cMap);
            session.setAttribute("sumMap",sumMap);
        }else {
            sum = (Double) session.getAttribute("sum");
            cMap = (Map<String,Integer>) session.getAttribute("countMap");
        }
/*        if (!"shoppingcart".equals(request.getParameter("shoppingcartto"))){
            sum = (Double) session.getAttribute("sum");
            cMap = (Map<String,Integer>) session.getAttribute("countMap");
        }else {


            for (String id :
                    ids) {
                String sumi = request.getParameter("sum" + id);
//                得到每一种鲜花的购买数量
                String count = request.getParameter("count"+id);
                int c = 0;
                if (count != null && !"".equals(count)){
                    c = Integer.parseInt(count);
                }
                cMap.put(id,c);
                double sumii =0.0;
                if (sumi != null && !sumi.equals("")){
                    sumii = Double.parseDouble(sumi);
                }
//                得到每一种鲜花 以及对应的支付金额
                sumMap.put(id,sumii);
                sum += sumii;
            }
            session.setAttribute("sum",sum);
            session.setAttribute("countMap",cMap);
            session.setAttribute("sumMap",sumMap);
        }*/


        UserService service = new UserServiceImpl();
        Tuser tuser =(Tuser) request.getSession().getAttribute("tuser") ;

//        request.getAttribute()
        try {
            List<Address> addresslist = service.getAddress(tuser);
            Address address = service.getAddressone(tuser);
            session.setAttribute("addresslist",addresslist);
            session.setAttribute("address",address);
            result = "checkout.jsp";
//            request.getRequestDispatcher("checkout.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//    login
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public  String login(HttpServletRequest request){
        String result ="";
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        //        System.out.println("doPost");
//        request 获取前端的数据传给servlet
//        获取页面的用户名和密码
//        getParameter 以String形式返回请求参数的值 如果不存在 返回null
        String uname = request.getParameter("Userame");
        String pwd = request.getParameter("Password");
        String role = request.getParameter("role");
//        System.out.println("role===="+role);
        UserService us = new UserServiceImpl();
        try {
            Tuser tuser = us.login(uname,pwd,role);
            if (tuser == null ){
//                提示客户登录失败
                request.setAttribute("result","登录失败 请重新登录");
//            登录失败    返回登录页面
                result = "login.jsp";
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//                String role1 = Role.MANAGER;
            }else{

            /*
//                        登录成功进行计数操作
                ServletContext application = this.getServletContext();
                Integer count = (Integer) application.getAttribute("logincount");
//                        如果以上值为空则表示第一次登录，则要将值设置为1
                if (count == null){
                    count = 1;
                }else {
                    count++;
                }
//                        最终都需要将此值存到上下文中
                application.setAttribute("logincount",count);
//                                自动登录
                Cookie cookie = new Cookie("usercookie",uname+"#"+pwd+"#"+role);
                cookie.setMaxAge(60*5);
                response.addCookie(cookie);

                */
//               成功跳转到main.html页面
//               为了在任何地方 获取到用户信息 我们将用户信息存储到session中
                HttpSession session = request.getSession();
                session.setAttribute("tuser",tuser);
//                从购物车登录过来 需要跳转到购物车页面
//                获取type 的值
                String type = request.getParameter("type");
                if ( "car".equals(type)){
//                    action -> action get->post
                    result = "forward:addCar.action";
                }else{
                    result = "forward:show.action";
                }
//                request.getRequestDispatcher("ShowFlowerServlet").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

//    添加购物车
    @RequestMapping("/addCar")
    public String addCar(HttpServletRequest request){
        String result = null ;
        //加入购物车要已经登录 判断是否登录
//        session 存取 登录信息
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        Tuser tuser = (Tuser) session.getAttribute("tuser");
        String fid = request.getParameter("fid");
        if (tuser == null) {
//            因为登录之后 依然能将当前鲜花添加到购物车 所以将 信息存储到 session
            session.setAttribute("fid", fid);
//            传递一个标识 表示从购物车到登录页面
            request.setAttribute("type", "car");

//        没有则跳到登录页
            result = "login.jsp";
//            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
//          因为登录成功后 跳转到此页面 获取不到fid的 要从session 中获取
//            所以可以判断是否有fid 没有则从session 中读取
            if (fid == null || "".equals(fid)) {
                fid = (String) session.getAttribute("fid");
            }

            if (fid != null) {
                int flowerid = 0;
                if (fid != null && !fid.equals("")) {
                    flowerid = Integer.parseInt(fid);
                }
                try {
                    int no = userService.addCar(tuser, flowerid);
                    if (no == 0) {
                        request.setAttribute("result", "添加失败");
                    } else if (no == 1) {
                        request.setAttribute("result", "添加成功");
                    } else if (no == 6) {
                        request.setAttribute("result", "已经添加过了呢");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//                将要在购物车中要显示的花存储
            List<ShopCar> shopCarList = null;
            try {
                shopCarList = userService.getCar(tuser);
                //跳转页面
                request.setAttribute("shopCarList", shopCarList);
                result = "shoppingcart.jsp";
//                request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

/*
// 添加购物车 POST方法
    @RequestMapping(value = "addCarPost" ,method = RequestMethod.POST)
    public String addCarPost(HttpServletRequest request){
        String result = null ;
        //加入购物车要已经登录 判断是否登录
//        session 存取 登录信息
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        Tuser tuser = (Tuser) session.getAttribute("tuser");
        String fid = request.getParameter("fid");
        if (tuser == null) {
//            因为登录之后 依然能将当前鲜花添加到购物车 所以将 信息存储到 session
            session.setAttribute("fid", fid);
//            传递一个标识 表示从购物车到登录页面
            request.setAttribute("type", "car");

//        没有则跳到登录页
            result = "login.jsp";
//            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
//          因为登录成功后 跳转到此页面 获取不到fid的 要从session 中获取
//            所以可以判断是否有fid 没有则从session 中读取
            if (fid == null || "".equals(fid)) {
                fid = (String) session.getAttribute("fid");
            }

            if (fid != null) {
                int flowerid = 0;
                if (fid != null && !fid.equals("")) {
                    flowerid = Integer.parseInt(fid);
                }
                try {
                    int no = userService.addCar(tuser, flowerid);
                    if (no == 0) {
                        request.setAttribute("result", "添加失败");
                    } else if (no == 1) {
                        request.setAttribute("result", "添加成功");
                    } else if (no == 6) {
                        request.setAttribute("result", "已经添加过了呢");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//                将要在购物车中要显示的花存储
            List<ShopCar> shopCarList = null;
            try {
                shopCarList = userService.getCar(tuser);
                //跳转页面
                request.setAttribute("shopCarList", shopCarList);
                result = "shoppingcart.jsp";
//                request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

*/

//    显示所有鲜花信息
    @RequestMapping("/show")
    public String showAll(HttpServletRequest request,String name,String result, Model model ) {
        System.out.println("name"+ name + "  result"+ result);
//        request.setAttribute("name",name);
//        request.setAttribute("result",result);
        model.addAttribute("name",name);
        model.addAttribute("result",result);
        UserService userService = new UserServiceImpl();
        //分页  上一页 up  下一页 down 当前页  page 总页数 allpage
//        获取总页数是为了 判断下一页是否为尾页
//        因为现在是修改所以 这样简便
        String p = request.getParameter("page");
        p = p == null ? "1" : p;//当前值为null 则表示第一次进入此页面，设置初始值为1
        int page = Integer.parseInt(p);
        int up = page - 1;
        int down = page + 1;
        int allPage = 0;
        try {
            allPage = userService.getPage(2);//参数注明每页显示几条记录 这里是两条
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //      dopost跳dopost
//        System.out.println("show daopost");
        //我们希望在跳转到main.jsp之前从数据库中获取到鲜花信息
        String index = request.getParameter("toshow");
        request.setAttribute("toshow", index);

        try {
//            自动登录
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
//                查住存储的user 信息
                for (Cookie cookie :
                        cookies) {
                    if ("usercookie".equals(cookie.getName())) {
                        String cookievalue = cookie.getValue();
//                        字符串分割
                        String[] cvalue = cookievalue.split("#");
                        Tuser tuser = userService.login(cvalue[0], cvalue[1], cvalue[2]);
//                        HttpSession session = request.getSession();
                        request.getSession().setAttribute("tuser", tuser);
                    }
                }
            }
/*
            ServletContext application = this.getServletContext();
            Integer vistercount = (Integer) application.getAttribute("vistercount");
//                        如果以上值为空则表示第一次访问，则要将值设置为1
            if (vistercount == null) {
                vistercount = 1;
            } else {
                vistercount++;
            }
//                        最终都需要将此值存到上下文中
            application.setAttribute("vistercount", vistercount);
*/

//            实现分页 所以要传两个参数  当前页 每页显示几条
            List<Flower> flowerList = userService.getAll(page, 2);
            //当获取到所有的鲜花后，我们可以将鲜花的信息存储到request里,储存的目的就是为了在页面获取数据
//            分页 上一页 up  下一页 down 当前页  page 总页数 allpage
            request.setAttribute("page", page);
            request.setAttribute("up", up);
            request.setAttribute("down", down);
            request.setAttribute("allPage", allPage);
            request.setAttribute("flowers", flowerList);
//            request.getRequestDispatcher("main.jsp").forward(request,response);
//            request.getRequestDispatcher("mainjava.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
return "mainjava.jsp";

}
/**
 * 显示鲜花详情信息
 *
 */
@RequestMapping("/detail")
public String getFlower(HttpServletRequest request) {
            String fid = request.getParameter("fid");
            int flowerid = 0;
            if (fid != null && !fid.equals("")) {
                flowerid = Integer.parseInt(fid);
            }
            UserService userService = new UserServiceImpl();
            try {
                Flower flower = userService.getOne(flowerid);
                request.setAttribute("flower", flower);
                return "productdetail.jsp";
        //        request.getRequestDispatcher("productdetail.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "productdetail.jsp";
            }
}

