package com.xiong.myrcp01.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

public class FirstPage extends FormPage {

	public static final String ID = "com.fengmanfei.myrcp.forms.FirstPage";

	public FirstPage(FormEditor editor) {
		// ���췽��������Formҳ��ID������
		super(editor, ID, "��һҳ");
	}

	// ���Ǹ����еķ���
	// �ڸ÷����д�����������ĸ��ֿؼ�
	protected void createFormContent(IManagedForm managedForm) {
		// ͨ��managedForm�����ñ������߶���
		FormToolkit toolkit = managedForm.getToolkit();
		// ͨ��managedForm������ScrolledForm�ɹ����ı�������
		ScrolledForm form = managedForm.getForm();
		// ���ñ����ı�
		form.setText("���ǵ�һҳ��Hello, Eclipse ����");
		// �������񲼾�
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 2;// ���������
		layout.bottomMargin = 10;// �²���
		layout.topMargin = 10;// �ϲ���
		layout.leftMargin = 10;// �󲹰�
		layout.rightMargin = 10;// �Ҳ���
		form.getBody().setLayout(layout);// ���ñ���Ĳ���

		// ������һ����ǩ
		Label l1 = toolkit.createLabel(form.getBody(), "���Ǻܳ���һ���ı��ı�1", SWT.WRAP);
		// �����ڶ�����ǩ
		Label l2 = toolkit.createLabel(form.getBody(), "�����ı�2", SWT.WRAP);
		// ����һ��TableWrapData��������Ϊˮƽ�ʹ�ֱ����ʽ���
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
		// ����������Ӧ�õ��ڶ�����ǩ
		l2.setLayoutData(td);
		Label l3 = toolkit.createLabel(form.getBody(), "�����ı�3", SWT.WRAP);
		// ��������ǩ�Ĳ�������
		td = new TableWrapData();
		td.colspan = 2;// ���õ�Ԫ��Ŀ�����
		l3.setLayoutData(td);
		// ���ĸ���ǩ�Ĳ�������
		Label l4 = toolkit.createLabel(form.getBody(), "�����ı�4", SWT.WRAP);
		td = new TableWrapData();
		td.rowspan = 2;// ���õ�Ԫ�������
		td.grabVertical = true;// ��ֱ��ռ
		l4.setLayoutData(td);
		Label l5 = toolkit.createLabel(form.getBody(), "�����ı�5", SWT.WRAP);
		Label l6 = toolkit.createLabel(form.getBody(), "�����ı�6", SWT.WRAP);
		form.getBody().setBackground(form.getBody().getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	}
}
