package com.xiong.myrcp01.main;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MyRCPActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.xiong.mycrp01"; //$NON-NLS-1$

	// The shared instance
	private static MyRCPActivator plugin;
	
	/**
	 * The constructor
	 */
	public MyRCPActivator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MyRCPActivator getDefault() {
		return plugin;
	}
	
	public static ImageDescriptor getImageDescriptorFromPlugin(String image) {
		return imageDescriptorFromPlugin(PLUGIN_ID, image);
	}

}
