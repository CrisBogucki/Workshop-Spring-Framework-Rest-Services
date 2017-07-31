package pl.asseco.workshop.calculationModule.Server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by krzysztof.bogucki on 28 lip 2017.
 */
public class SampleServer {

    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());

        final HttpServlet servlet = new HttpServlet() {
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Writer w = resp.getWriter();
                w.write("Hello, World!");
            }
        };

        final HttpServlet servlet1 = new HttpServlet() {
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Writer w = resp.getWriter();
                w.write("Hello, World!"); 
            }
        };


        Tomcat.addServlet(ctx, "hello", servlet);
   		Tomcat.addServlet(ctx, "hello1", servlet1);

   		ctx.addServletMappingDecoded("/halo/", "hello");
   		ctx.addServletMappingDecoded("/halo1/", "hello1");

   		tomcat.start();
   		tomcat.getServer().await();

    }

}


