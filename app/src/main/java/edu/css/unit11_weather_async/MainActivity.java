package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Tom Gibbons, Chris Killian
 */
public class MainActivity extends AppCompatActivity {
    EditText etLoc; //location
    EditText etTemp; //temperature
    EditText etWind; //wind
    EditText etVis; //visibility

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    /**
     * On button click AsyncWeatherDownloader executes.
     * @param v
     * @throws XmlPullParserException Signals XML Pull parser related faults.
     * @throws URISyntaxException Indicates that a string could not be parsed as a URI reference.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }

    /**
     * Sets etTemp text box based on the data returned from the API.
     * @param newTemp the temperature data result.
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    /**
     * Sets etWind text box based on the data returned from the API.
     * @param newWind the wind data result.
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    /**
     * Gets the location/ZIP code.
     * @return the location in a string format.
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }

    /**
     * Displays a message of the status of getting the weather data.
     * @param newStatus the status of the getting the weather data.
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
