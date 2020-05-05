package org.vaadin.bkaso;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
/**
 * Its free vaadin addon for confirmation dialog
 * @author bharatk
 *
 */
interface OkEvent {
	void execute(ComponentEvent<Button> clickEvent);
}

public class ConfirmDialog extends Dialog {

	private static final long serialVersionUID = 1L;

	private Button okButton = new Button("Yes");
	private Button cancelButton = new Button("No");
	private Label label = new Label("Are you sure to delete?");

	public static ConfirmDialog show(OkEvent okEvent) {
		return new ConfirmDialog(okEvent);
	}

	public static ConfirmDialog show(String customConfirmMsg, OkEvent ee) {
		return new ConfirmDialog(customConfirmMsg, ee);
	}

	public static ConfirmDialog show(String customConfirmMsg, String okLabel, String cancelLabel, OkEvent ee) {
		return new ConfirmDialog(customConfirmMsg, okLabel, cancelLabel, ee);
	}

	public ConfirmDialog(OkEvent ee) {
		createUI();
		addOkListener(ee);
	}

	public ConfirmDialog(String customConfirmMsg, OkEvent ee) {
		this(ee);
		label.setText(customConfirmMsg);
	}

	public ConfirmDialog(String customConfirmMsg, String okLabel, String cancelLabel, OkEvent ee) {
		this(customConfirmMsg, ee);
		setOkLabel(okLabel);
		setCancelLabel(cancelLabel);
		createUI();
	}

	public void setConfirmMessage(String customConfirmMsg) {
		label.setText(customConfirmMsg);
	}

	public void setOkLabel(String okLabel) {
		okButton.setText(okLabel);
	}

	public void setCancelLabel(String cancelLabel) {
		cancelButton.setText(cancelLabel);
	}

	public void createUI() {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.add(okButton, cancelButton);
		Div div = new Div();
		div.setHeight("50px");
		add(label, div, buttonLayout);
		cancelButton.addClickListener(e -> {
			this.close();
		});
		open();
	}

	public void addOkListener(OkEvent ee) {
		okButton.addClickListener(e -> {
			ee.execute(e);
			this.close();
		});
	}

	public void addCancelListener(OkEvent ee) {
		cancelButton.addClickListener(e -> {
			ee.execute(e);
			this.close();
		});
	}

}
