
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Hello extends Application{

	private static String num1;
	private static String num2;
	private static int operator;
	
	
    @Override
    public void start(Stage primaryStage) {
        
    	GridPane grid = new GridPane();
            
        
        populateGrid(grid);
        
        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private static void populateGrid(GridPane grid){
    	Button btn1 = new Button();
        makeNumberButton(grid, btn1, "1", "1", 0, 0);
        
        Button btn2 = new Button();
        makeNumberButton(grid, btn2, "2", "2", 1, 0);
        
        Button btn3 = new Button();
        makeNumberButton(grid, btn3, "3", "3", 2, 0);
        
        Button btn4 = new Button();
        makeNumberButton(grid, btn4, "4", "4", 0, 1);
        
        Button btn5 = new Button();
        makeNumberButton(grid, btn5, "5", "5", 1, 1);
        
        Button btn6 = new Button();
        makeNumberButton(grid, btn6, "6", "6", 2, 1);
        
        Button btn7 = new Button();
        makeNumberButton(grid, btn7, "7", "7", 0, 2);
        
        Button btn8 = new Button();
        makeNumberButton(grid, btn8, "8", "8", 1, 2);
        
        Button btn9 = new Button();
        makeNumberButton(grid, btn9, "9", "9", 2, 2);
        
        Button btn0 = new Button();
        makeNumberButton(grid, btn0, "0", "0", 1, 3);
        
        
        
        Button btnm = new Button();
        Button btnd = new Button();
        Button btna = new Button();
        Button btns = new Button();
        
        Operator add = new Addition();
        Operator sub = new Subtraction();
        Operator mult = new Multiplication();
        Operator div = new Division();
       
        makeOperationButton(grid, btnm, add, 5, 0);
        makeOperationButton(grid, btnd, sub, 5, 1);
        makeOperationButton(grid, btna, mult, 5, 2);
        makeOperationButton(grid, btns, div, 5, 3);
        
        Button btne = new Button();
        btne.setText("=");
        btne.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent event) {
        		Integer temp1 = Integer.parseInt(num1);
        		Integer temp2 = Integer.parseInt(num2);
        		
        		if(operator == 1) {
        			temp2 += temp1;
        			System.out.println(temp2);
        		}
        		else if(operator == 2) {
        			temp2 = temp2 - temp1;
        			System.out.println(temp2);
        		}
        		else if(operator == 3) {
        			if(temp1 == 0){
        				System.out.println("Error: Divide by Zero");
        			}
        			else{
        				temp2 = temp2/temp1;
            			System.out.println(temp2);
        			}
        		}
        		else if(operator == 4) {
        			temp2 *= temp1;
        			System.out.println(temp2);
        		}
        		else if(operator == 0) {
        			System.out.println("op == 0");
        		}
        		
        		temp1 = temp2 = 0;
        		num1 = num2 = "0";
        	}
        });
        
        grid.add(btne, 5, 4);
    }
    
    
    
	 public static void main(String[] args) {
		 	num1= "";
		 	num2= "";
		 	operator = 0;
	        launch(args);
	    }
	 
	 
	 private static void makeNumberButton(GridPane grid, Button btn, String label, 
	 String handle, int x, int y){
		
		 
		 btn.setText(label);
		 btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				num1 += handle;
			}
		 });
 		
 		
 		grid.add(btn, x, y);
	 }
	 
	 private static void makeOperationButton(GridPane grid, Button btn, Operator op, int x, int y){
				
				 
				 btn.setText(op.getLabel());
				 btn.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						num2 = num1; 
						num1 = "0";
						operator = op.getOperator();
					}
				 });
		 		
		 		
		 		grid.add(btn, x, y);
	 }
	 
	 
	 
}









