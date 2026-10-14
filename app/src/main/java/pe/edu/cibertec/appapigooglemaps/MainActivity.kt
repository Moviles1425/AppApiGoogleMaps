package pe.edu.cibertec.appapigooglemaps

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.GoogleMap
import pe.edu.cibertec.appapigooglemaps.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val requestPermisionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted ->
        if(isGranted){
            enableMyLocation()
        }else{
            Toast.makeText(applicationContext,"Permiso de ubicación denegada",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun enableMyLocation(){

    }
}