package zumbi.Componentes;

import zumbi.Interfaces.IGUI.IGUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUI implements IGUI{

	protected Shell shell;
	
	private int diag = 0;
	
	public void openDiag(Button atual) {
		if(diag>1)
			atual.setVisible(true);
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(700, 432);
		shell.setText("SWT Application");
		
		int a = 0;
		
		Button btnMedico = new Button(shell, SWT.NONE);
		Button btnPaciente = new Button(shell, SWT.NONE);
		Label lblMedico = new Label(shell, SWT.NONE);
		Label lblPaciente = new Label(shell, SWT.NONE);
		Button btnDiagnostico = new Button(shell, SWT.NONE);
		
		//Button btnMedico = new Button(shell, SWT.NONE);
		btnMedico.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnMedico.setVisible(false);
				lblMedico.setVisible(true);
				diag++;
				openDiag(btnDiagnostico);
			}
		});
		btnMedico.setBounds(56, 185, 159, 29);
		btnMedico.setText("Generate Doctor");
		
		//Button btnPaciente = new Button(shell, SWT.NONE);
		btnPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnPaciente.setVisible(false);
				lblPaciente.setVisible(true);
				diag++;
				openDiag(btnDiagnostico);
			}
		});
		btnPaciente.setBounds(490, 185, 150, 29);
		btnPaciente.setText("Generate Patient");
		
		//Label lblMedico = new Label(shell, SWT.NONE);
		lblMedico.setImage(SWTResourceManager.getImage("/home/sraterra/Documents/ProjetoMC322/Trabalho_ZombieHealth/imgs/penguin_doctor.png"));
		lblMedico.setBounds(36, 40, 200, 300);
		lblMedico.setVisible(false);
		
		//Label lblPaciente = new Label(shell, SWT.NONE);
		lblPaciente.setImage(SWTResourceManager.getImage("/home/sraterra/Documents/ProjetoMC322/Trabalho_ZombieHealth/Imagens/patient.png"));
		lblPaciente.setBounds(460, 40, 200, 300);
		lblPaciente.setVisible(false);
		
		//Button btnDiagnostico = new Button(shell, SWT.NONE);
		btnDiagnostico.setAlignment(SWT.RIGHT);
		btnDiagnostico.setBounds(303, 185, 79, 29);
		btnDiagnostico.setText("Diagnose");
		btnDiagnostico.setVisible(false);

	}
	
}
