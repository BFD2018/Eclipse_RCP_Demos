package com.xiong.myrcp01.main;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.xiong.myrcp01.views.MyFormView;
import com.xiong.myrcp01.views.SampleView;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addStandaloneView(MyFormView.ID, true, IPageLayout.LEFT, .3f, editorArea);

		// layout.addStandaloneView(OpenEditorView.ID,true,IPageLayout.RIGHT,.3f,editorArea);
		// layout.addView(FirstView.ID,IPageLayout.LEFT,0.45f,editorPart);
		// Ϊ͸��ͼ����һ����ͼ
		/*
		 * layout.addStandaloneView(IPageLayout.ID_OUTLINE,//��ͼ��ID
		 * true,//�Ƿ���ʾ��ͼ�ı��� IPageLayout.LEFT,//������͸��ͼ�����λ��
		 * 0.45f,//��ռ͸��ͼ�İٷֱ�Ϊ45% editorArea);//���ӵ��������
		 * layout.addStandaloneView(AnotherView.ID,//��ͼ��ID true, IPageLayout.BOTTOM,
		 * 0.45f, editorArea);
		 */
		layout.addStandaloneView(SampleView.ID, true, IPageLayout.TOP, 0.45f, editorArea);
		layout.addStandaloneView(IPageLayout.ID_TASK_LIST, true, IPageLayout.RIGHT, 0.45f, SampleView.ID);
		/*
		 * IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM,
		 * 0.25f, editorArea); bottom.addView(IPageLayout.ID_RES_NAV);
		 * bottom.addView(IPageLayout.ID_PROP_SHEET);
		 * bottom.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		 * 
		 * IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.25f,
		 * editorArea); left.addView(IPageLayout.ID_OUTLINE);
		 * left.addView(IPageLayout.ID_PROBLEM_VIEW);
		 * //topLeft.addView(IPageLayout.ID_PROP_SHEET);
		 * //topLeft.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		 * layout.addFastView(AnotherView.ID); //layout.setEditorAreaVisible(false);
		 */
	}
}
