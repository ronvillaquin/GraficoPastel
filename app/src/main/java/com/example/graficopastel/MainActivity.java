package com.example.graficopastel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.SliceValue;
import android.graphics.Color;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/*en el buil gradle module app pegamos en allprojects
maven {
        url 'https://jitpack.io'
        }

 */
/* y en buil gradle project graficos app
implementation 'com.github.lecho:hellocharts-android:v1.5.8'
 */
/*Dentro de la carpeta del proyecto pegamos el archivo .jar y exportamos el .jar
* clic derecho en la carpeta app - open module setinng - simbolo + - archvo jar -
*  buscamos en la carpeta del proyecto - aceptar aceptar listoo*/

public class MainActivity extends AppCompatActivity
{


    PieChartView pieChartView;
    int a = 10;
    private Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner);

        graficoPastel();
        spinner();
    }

    public void graficoPastel(){
        PieChartView pieChartView = findViewById(R.id.chart);

        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(a, Color.BLACK).setLabel("Casa: $10"));
        pieData.add(new SliceValue(10, Color.GRAY).setLabel("Auto: $4"));
        pieData.add(new SliceValue(15, Color.RED).setLabel(a+"%"));
        pieData.add(new SliceValue(11, Color.MAGENTA).setLabel("Pc: $28"));
        pieData.add(new SliceValue(14, Color.BLUE).setLabel("Pc: $28"));
        pieData.add(new SliceValue(5, Color.YELLOW).setLabel("Pc: $28"));
        pieData.add(new SliceValue(5, Color.GREEN).setLabel("Pc: $28"));
        //pra poder colocar el color desde el xml color
        pieData.add(new SliceValue(10, getResources().getColor(R.color.rojo)).setLabel("MAria"));
        pieData.add(new SliceValue(10, getResources().getColor(R.color.verde)).setLabel("MAria"));
        pieData.add(new SliceValue(10, getResources().getColor(R.color.azul)).setLabel("MAria"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Prueba de grafico pie").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartData.setHasCenterCircle(true).setCenterText2("MARIA MARIA pie").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }

    public void spinner(){
        //ahora se crea u vector para agregar los valores al vector
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        // para poder mostrar el texto del vestor hay que comunicar el spinner con el vector

        // se coloca arrayAdapter y el tipo de dato con el que se trabaja string o entero
        // adapter es el tipo de objeto que se creo que se puede nombrar como deseemos
        //se crea el new array se hace referencia al mismo con this se le dice que es un spinner
        //simple ya que se modificara su grafica despues y se coloca el vector opciones
        //primero se utilizo el tipo de spinner que nos da android luego se modifico mediante un xml q se creo para darle stylo
        //
        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        // se coloca la siguiente linea de codigo en ves de la anterior haciendo referencia al nuevo xml que se creo para darle diseño al spinner
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        // ahora hay que asignar al spiner el opjeto adapter que cremos en la linea de arriba
        spinner1.setAdapter(adapter);
    }
}