package aop;

import java.io.FileFilter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionListener;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ddd  {
	
	public static void main(String[] args) {
		treenode tree=new treenode();
		tree.val=100;
		tree.addnode(105);
		tree.addnode(1100);
		tree.addnode(23);
		tree.addnode(34);
		tree.addnode(454);
		tree.addnode(33);
		
		System.out.println(tree);
		
	}
	
	
	public static class treenode{
		treenode lnode;
		treenode rnode;
		int self=0;   //1 l  2 r
		int val;
		
		public void addnode(int val) {
			if(val<this.val) {
				if(lnode==null) {
					lnode=new treenode();
					lnode.self=1;
					lnode.val=val;
				}else {
					lnode.addnode(val);
				}
			}else {
				if(rnode==null) {
					rnode=new treenode();
					rnode.self=2;
					rnode.val=val;
				}else {
					rnode.addnode(val);
				}
			}
		}
		
		@Override
		public String toString() {
			
			return (self==0?"":self==2?"ÓÒ":"×ó")+"½Úµã"+val +"\n"+ (lnode!=null?lnode:"") +"\n"+(rnode!=null?rnode:"") +"\n";
		}
	}

}
