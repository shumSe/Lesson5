package ru.mirea.shumikhin.lesson5

import android.R
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import ru.mirea.shumikhin.lesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val listSensor: ListView = binding.listView
        val arrayList: ArrayList<HashMap<String, Any?>> = ArrayList()
        for (i in sensors.indices) {
            val sensorTypeList: HashMap<String, Any?> = HashMap()
            sensorTypeList["Name"] = sensors[i].name
            sensorTypeList["Value"] = sensors[i].maximumRange
            arrayList.add(sensorTypeList)
        }
        val mHistory = SimpleAdapter(
            this, arrayList, R.layout.simple_list_item_2, arrayOf("Name", "Value"), intArrayOf(
                R.id.text1, R.id.text2
            )
        )
        listSensor.adapter = mHistory
    }
}