package com.xiong.myrcp01.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class AnotherView extends ViewPart {
	private Text text;
	public static final String ID = "com.fengmanfei.myrcp.views.AnotherView";

	public AnotherView() {
		super();
	}

	public void createPartControl(Composite parent) {
		text = new Text(parent, SWT.NONE);
	}

	public void setFocus() {
		text.setFocus();
	}

	public void setContent(String content) {
		text.setText(content);
	}
}
