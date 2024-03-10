package com.xiong.myrcp01.forms;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.xiong.myrcp01.forms.advance.FileMasterDetailsBlock;

public class MasterDetailPage extends FormPage {

	public static final String ID = "com.fengmanfei.myrcp.forms.MasterDetailPage";

	// ����MasterDetailҳ�沿�ֶ���
	private FileMasterDetailsBlock block;

	public MasterDetailPage(FormEditor editor) {
		super(editor, ID, "Master/Detailҳ");
		block = new FileMasterDetailsBlock(this);
	}

	/*
	 * ManagedForm��װ��formԪ�ص��������ڹ��������formԪ��֮����¼�֪ͨ
	 * ManagedForm����������һ��form����������һ��form���ҿ���ע��IFormPart��
	 * ���Խ�ManagedForm������'viewers'��form��managed form֮��Ĺ�ϵ�ͺ���
	 * Table��TableViewer�Ĺ�ϵһ����
	 */

	protected void createFormContent(IManagedForm managedForm) {
		// ��ñ�������
		ScrolledForm form = managedForm.getForm();
		// ���ñ����ı���
		form.setText("����һ������ļ���Master/Detailҳ��");
		// �÷����ǳ���Ҫ�����𴴽�Master��Detail���򣬾�����������
		block.createContent(managedForm);
	}

}
