package com.xiong.myrcp01.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class JsEditor extends EditorPart {
	public static final String ID = "com.xiong.myrcp01.editors.JsEditor";
	private Text text;
	private boolean bDirty = false;

	public JsEditor() {
		super();
	}

	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		this.setPartName(input.getName());
	}

	@Override
	public void createPartControl(Composite parent) {
		text = new Text(parent, SWT.NONE);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (!isDirty()) {
					setDirty(true);
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			}
		});
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			monitor.beginTask("�����ļ�...", 100);

			for (int i = 0; i < 10 && !monitor.isCanceled(); i++) {
				Thread.sleep(500);
				monitor.worked(10);
				double d = (i + 1) / 10d;
				monitor.subTask("�����" + d * 100 + "%");// ��ʾ����״̬
			}
			monitor.done();
			if (monitor.isCanceled())
				throw new InterruptedException("ȡ������");
		} catch (InterruptedException e) {
			;
		}
	}

	@Override
	public void doSaveAs() {

	}

	public boolean isDirty() {
		return bDirty;
	}

	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void setFocus() {
		text.setFocus();
	}

	public void setDirty(boolean b) {
		bDirty = b;
	}

}
