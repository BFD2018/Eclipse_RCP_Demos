package com.xiong.myrcp01.dialog;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.xiong.myrcp01.main.MyRCPActivator;

public class TestDataBindingDialog extends TitleAreaDialog {
	private final String DIALOG_TITLE = "Test Eclipse data binding";
	private final String DIALOG_MESSAEG = "please use eclipse data binding";

	private final String[] COUNTRIES = new String[] { "China", "USA", "Japan", "UK", "Korea", "Germany", "France" };

	private Text _usernameText;
	private Text _pwdText;
	private Combo _countryCombo;

	public TestDataBindingDialog(Shell parentShell) {
		super(parentShell);
	}


	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent); // 利用父类的方法！
		setTitle(DIALOG_TITLE);
		setMessage(DIALOG_MESSAEG, IMessageProvider.INFORMATION);
		setTitleImage(MyRCPActivator.getImageDescriptorFromPlugin("/icons/eclipse48.png").createImage());

		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(layoutData);

		Group group1 = new Group(composite, SWT.None);
		group1.setText("User Infomation");
		group1.setLayout(new GridLayout(3, false));
		group1.setLayoutData(new GridData(GridData.FILL_BOTH));

		// line1
		Label _usernameLabel = new Label(group1, SWT.NONE);
		_usernameLabel.setText("UserName：");
		_usernameText = new Text(group1, SWT.BORDER);
		_usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button button = new Button(group1, SWT.PUSH);
		button.setText("Browse");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}

		});

		// line2
		Label pwdLabel = new Label(group1, SWT.NONE);
		pwdLabel.setText("PassWord：");
		_pwdText = new Text(group1, SWT.BORDER);
		GridData pwdGridData = new GridData(GridData.FILL_HORIZONTAL);
		pwdGridData.horizontalSpan = 2;
		_pwdText.setLayoutData(pwdGridData);

		// line3
		Label countryLabel = new Label(group1, SWT.NONE);
		countryLabel.setText("Country：");
		_countryCombo = new Combo(group1, SWT.SINGLE | SWT.READ_ONLY | SWT.DROP_DOWN);
		GridData countryGridData = new GridData();
		countryGridData.widthHint = 100;
		_countryCombo.setLayoutData(countryGridData);
		_countryCombo.setItems(COUNTRIES);
		_countryCombo.select(0);
		_countryCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});

		return composite;
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	@Override
	protected boolean isResizable() {
		// 设置对话框可以缩放
		return true;
	}

}
