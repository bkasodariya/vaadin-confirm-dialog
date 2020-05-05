# Paper Slider

Vaadin 14 Java plugin for confirmation dialog 

Confirmation dialog can be used as follow

'''
//with default message text and button labels
		ConfirmDialog.show(okEvent->{
			//ok event operation
			System.out.println("ok event operation");
		});
		
		//custom confirmation message and default button labels
		ConfirmDialog.show("Are you sure?",okEvent->{
			//ok event operation
			System.out.println("ok event operation");
		});
		
		//custom confirmation message, custom button labels 
		ConfirmDialog.show("Are you sure?","CustomOK","CustomCancel",okEvent->{
			//ok event operation
			System.out.println("ok event operation");
		});
		'''
		