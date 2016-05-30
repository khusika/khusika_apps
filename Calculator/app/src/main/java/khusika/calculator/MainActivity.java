package khusika.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean clear_screen = true;
    boolean operator_state = false ;
    boolean insert_state = false;
    boolean last_click = false;
    float Operand1 = 0f;
    float Operand2 = 0f;
    float Answer = 0f;
    String Operator = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void insert_text(String text){
        EditText screen = (EditText) findViewById(R.id.kotakText);
        if (this.clear_screen){
            screen.setText("");
            this.clear_screen = false;
        }
        this.insert_state = true;
        this.last_click = true;
        screen.append(text);
    }
    public void set_operator(String operator){
        EditText screen = (EditText) findViewById(R.id.kotakText);
        if (screen.getText().toString().equals(".")) screen.setText("0");
        if (this.insert_state && this.operator_state && this.last_click){
            calculator();
        }
        if (screen.getText().toString().length() > 0 ){
            this.Operand1 = Float.parseFloat(screen.getText().toString());
        }
        this.operator_state = true;
        this.clear_screen = true;
        this.last_click = false;
        if (operator.equals("+"))		this.Operator = "+";
        else if (operator.equals("-"))	this.Operator = "-";
        else if (operator.equals("*"))	this.Operator = "*";
        else if (operator.equals("/"))	this.Operator = "/";
        else if (operator.equals("√")){
            this.Answer = (float) Math.sqrt(Float.parseFloat(screen.getText().toString()));
            screen.setText(this.Answer + "");
            this.clear_screen = true;
            this.Operand1 = 0f;
            this.Operand2 = 0f;
            this.Operator = "";
            this.last_click = true;
            this.operator_state = false ;
        }else if (operator.equals("d")){
            this.Answer = 1 / Float.parseFloat(screen.getText().toString());
            screen.setText(this.Answer + "");
            this.clear_screen = true;
            this.Operand1 = 0f;
            this.Operand2 = 0f;
            this.Operator = "";
            this.last_click = true;
            this.operator_state = false ;
        }
        else if (operator.equals("^"))	this.Operator = "^";
        else if (operator.equals("%"))	this.Operator = "%";
    }

    public void calculator(){
        EditText screen = (EditText) findViewById(R.id.kotakText);
        if (screen.getText().toString().equals(".")){
            screen.setText("0");
        }
        if (screen.getText().toString().length() > 0){
            this.Operand2 = Float.parseFloat(screen.getText().toString());
        }
        if (this.Operator.equals("+")) {
            this.Answer = this.Operand1 + this.Operand2;
        } else if (this.Operator.equals("-")){
            this.Answer = this.Operand1 - this.Operand2;
        } else if (this.Operator.equals("*")){
            this.Answer =this.Operand1 * this.Operand2;
        } else if (this.Operator.equals("/")){
            this.Answer = this.Operand1 / this.Operand2;
        }else if (this.Operator.equals("^")){
            this.Answer = (float) Math.pow(this.Operand1, this.Operand2);
        }else if (this.Operator.equals("%")){
            this.Answer = Operand1 % this.Operand2;
        }else{
            this.Answer = Float.parseFloat(screen.getText().toString());
        }

        screen.setText(this.Answer + "");
    }
    public void ButtonClickHandler(View v){
        EditText screen = (EditText) findViewById(R.id.kotakText);
        switch(v.getId()){
            case R.id.tombolNol : insert_text("0"); break;
            case R.id.tombolSatu : insert_text("1"); break;
            case R.id.tombolDua: insert_text("2"); break;
            case R.id.tombolTiga: insert_text("3"); break;
            case R.id.tombolEmpat: insert_text("4"); break;
            case R.id.tombolLima: insert_text("5"); break;
            case R.id.tombolEnam : insert_text("6"); break;
            case R.id.tombolTujuh: insert_text("7"); break;
            case R.id.tombolDelapan : insert_text("8"); break;
            case R.id.tombolSembilan: insert_text("9"); break;
            case R.id.tombolTitik :
                if (!screen.getText().toString().contains(".") || this.operator_state){
                    insert_text(".");
                }
                break;
            case R.id.tombolTambah : 	set_operator("+"); break;
            case R.id.tombolKurang :	set_operator("-"); break;
            case R.id.tombolKali:	set_operator("*"); break;
            case R.id.tombolBagi:	set_operator("/"); break;
            case R.id.tombolAkar:	set_operator("√"); break;
            case R.id.tombolPangkat:	set_operator("^"); break;
            case R.id.tombolPersen:	set_operator("%"); break;
            case R.id.tombolSeper:	set_operator("d"); break;
            case R.id.tombolSamaDengan:
                if(screen.getText().toString().length() > 0 && this.Operator != ""){
                    calculator();
                    this.clear_screen = true;
                    this.Operand1 = 0f;
                    this.Operand2 = 0f;
                    this.Operator = "";
                    this.operator_state = false ;
                }
                break;
            case R.id.tombolHapus:
                if(screen.getText().toString().length() > 1){
                    String screen_new = screen.getText().toString().substring(0, screen.getText().toString().length()-1);
                    screen.setText(screen_new);
                    this.clear_screen = false;
                }else{
                    screen.setText("0");
                    this.clear_screen = true;
                }
                break;
            case R.id.tombolBersih:
                this.Operand1 = 0f;
                this.Operand2 = 0f;
                this.Answer = 0f;
                this.Operator = "";
                this.operator_state = false ;
                this.insert_state = false;
                this.last_click = false;
                this.clear_screen = true;
                screen.setText("0");
                break;
        }
    }
}
