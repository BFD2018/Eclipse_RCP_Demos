package com.xiong.myrcp01.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import com.xiong.myrcp01.main.MyRCPActivator;

public class JsEditorInput implements IEditorInput {
	private String input;

	public JsEditorInput(String input) {
		this.input = input;
	}

	public boolean exists() {
		return true;
	}

	public ImageDescriptor getImageDescriptor() {
		return MyRCPActivator.getImageDescriptorFromPlugin("icon/sample.gif");
	}

	public String getName() {
		return input;
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return input;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

}
