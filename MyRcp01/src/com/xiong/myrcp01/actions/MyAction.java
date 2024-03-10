package com.xiong.myrcp01.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import com.xiong.myrcp01.editors.JsEditor;
import com.xiong.myrcp01.editors.JsEditorInput;
import com.xiong.myrcp01.main.MyRCPActivator;

public class MyAction extends Action implements ISelectionListener, IWorkbenchAction {
	private IWorkbenchWindow window;
	public final static String ID = " com.fengmanfei.myrcp.actions.MyAction";
	private IStructuredSelection selection;

	public MyAction(IWorkbenchWindow window) {
		super("Test Action");
		setId(ID);
		setText("My Action");
		setToolTipText("My Action");
		setImageDescriptor(MyRCPActivator.getImageDescriptorFromPlugin("icons/sample.gif"));
		this.window = window;
		window.getSelectionService().addSelectionListener(this);
	}

	public void run() {
		String current = (String) selection.getFirstElement();
		IWorkbenchPage page = window.getActivePage();
		JsEditorInput editor = new JsEditorInput(current);
		try {
			page.openEditor(editor, JsEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}

	}

	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if (incoming instanceof IStructuredSelection) {
			selection = (IStructuredSelection) incoming;
			String s = (String) selection.getFirstElement();
			Assert.isNotNull(s);
			if (s.equals("Three"))
				setEnabled(true);
			else
				setEnabled(false);
		}
	}

	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

}
