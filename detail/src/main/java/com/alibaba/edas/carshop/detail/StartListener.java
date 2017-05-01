package com.alibaba.edas.carshop.detail;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.edas.carshop.itemcenter.ItemService;


/**
 * Alibaba Group EDAS. http://www.aliyun.com/product/edas
 */
public class StartListener implements ServletContextListener{

	@Override
	public void contextInitialized( ServletContextEvent sce ) {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( sce.getServletContext() );
		final ItemService itemService = ( ItemService ) ctx.getBean( "item" );
		Thread thread = new Thread( new Runnable() {
			@Override
			public void run() {
				while ( true ) {
					try {
						Thread.sleep( 5000l );
						System.out.println( itemService.getItemById( 1111 ) );
						System.out.println( itemService.getItemByName( "myname is le" ) );
					} catch ( Throwable e ) {
						e.printStackTrace();
					}
				}
			}
		} );
		thread.start();
	}

	@Override
	public void contextDestroyed( ServletContextEvent sce ) {
		// TODO Auto-generated method stub
	}

}
