package com.example.testapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView

class FragmentMainList : Fragment() {

    val args: Fragment by navArgs()

    lateinit var adapter: AdapterForMainList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdapterForMainList{myCar, position ->
            Toast.makeText(requireContext(),"Click btn №$position",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.mainToDescription, Bundle().apply {
                putString("description", myCar.fullDesc)
                putString("imageURL",myCar.urlImage)
            })
        }
        adapter.setNewData(createCars())
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.adapter = adapter
    }

    fun createCars(): List<MyCar> {
        return listOf(
            MyCar("BMW M4 Competition",
                "The BMW M4 Competition is the official name of the high-performance variant of the BMW M4 sports car.",
                "The BMW M4 coupe is a fire-breathing dragon capable of high-flying acrobatics. It's the two-door analog of the M3 super sedan, similarly pumped up by the automaker's M performance division for driving thrills. It borrows the M3's ferocious 473-hp twin-turbo inline six-cylinder engine, and we applaud BMW for making a six-speed manual gearbox and rear-drive standard. The ultra-intense Competition trim bumps power to 503 horsepower and requires an eight-speed automatic; all-wheel drive is optional. The M4's firm-riding suspension and sharp steering turn twisty roads into memorable encounters, but there's also plenty of luxury on board in addition to a reasonably roomy cabin. We do have our reservations about the M4's stiff ride, wispy steering feel, and overly complex configurable drive modes.",
                "https://prod.cosy.bmw.cloud/bmwweb/cosySec?COSY-EU-100-7331cqgv2Z7d%25i02uCaY3MuO2kOHUtWPfbYf0jPy10tLhu1XzWVo7puMLWFmdkAj5DOPitpsZ8XgY1nTNIowJ4HO3zkyXq%25sGM8snGhMQSk%2508Xc9Vo74giUnNF1VgxNJ0%25lJfVZ8XJaFBVKLB9MEWO5GalL7GqGAGEECrv0s9Ofw9E4GA0ogY%253NF9OALUollkIogOybQwunvLUgChSXF5GybUEqgtc89ChbNmEpiPoEqhk7BRKMLNmqn1cSJDyk7m5VKJXYCn178zBPltE5V1PaHVqfN8zVMRJw9SkPazDxK07dnMRaYWB9EQ5DxRte2LcZ8YWxfjfEgcPteWS6GERKMfjedw9hbBDS6jQ%250502Ydw6ZuTyoptQ%25wc3lLMifZu%25KXsyTHSc3uBr0UTJdKX324BDpTQBrXpFkaplZ24riIg6gscC4bVgvrt3RmFCoub%25cXJaHWp8Pfr" ),
            MyCar("Mercedes-Benz CLS",
                "The Mercedes-Benz CLS is a luxury sedan that is often referred to as a \"four-door coupe\" due to its sleek and sporty design.",
                "When parked, the Mercedes-Benz CLS-class has the presence of an alluring art piece sitting on full display in a gallery. It’s a curated collection of curves and corners that inspires the eyes to linger on its elegant shape and drink in its attractive detailing. Hop into the driver’s seat, though, and you’ll find that the chic four-door sedan is more than just eye candy. Inside the cabin, occupants are greeted with lavish luxury in the form of quality materials, tight fit-and- finish, and a dazzling dashboard display. The mechanics of this Mercedes are all E-class sedan underneath, and the pieces are tuned for supple ride comfort rather than curve-eating aggression. The standard, electrically-enhanced inline-six cylinder is velvet personified. The CLS is not a car for people who are enamored by pistons or sway bars or chunky brake calipers; it’s for folks who want to soak in the delights afforded by components engineered to transport them in silk-smooth style.",
                "https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/benz-cls-2020-index-1.png"),
            MyCar("Tesla Model S",
                "The Tesla Model S is a full-size luxury electric car that was first introduced by Tesla Motors in 2012.",
                "The car that kickstarted the EV revolution is starting to show its age. While the 2023 Tesla Model S falls behind newly developed rivals with more over-the-top features and longer driving ranges, the sedan-like hatchback continues to be competitive. After all, the Model S offers up to 405 miles of range on a single charge. Plus, the 1020-hp tri-motor Plaid performance model leaps to 60 mph in just 2.1 seconds, which is as quick as a multimillion-dollar hypercar. However, cutting-edge competitors such as the BMW i7 and Lucid Air have taken much of Tesla's spotlight. The Model S also has a six-figure price tag that just doesn't jibe with its mid-luxe interior, especially compared with the Lucid and BMW's deluxe cabins.  Still, the 2023 Model S remains the brand's flagship, offering access to its most up-to-date software and Tesla's advanced—albeit somewhat dubious—AutoPilot hands-free driving mode.",
                "https://www.torquenews.com/sites/default/files/styles/news/public/images/tesla_model_s_white_color.jpg"),
            MyCar("Subaru WRX STI",
                "The Subaru WRX STI is a high-performance version of the Subaru WRX compact car.",
                "Inspired by Subaru's factory-backed FIA World Championship Rally series race cars and tuned for maximum performance, the 2021 Subaru WRX STI will overwhelm the faint of heart. In fact, the STI's finicky turbocharged flat-four cylinder engine and firm suspension can startle even ardent driving enthusiasts. However, its tenacious all-wheel-drive system and manual-only transmission are notable hallmarks of the sporty Subaru sedan. And if the STI is too spicy for you, there's always the less edgy-albeit-still-raw WRX. While the STI lacks the cargo space of rival hi-po hatchbacks such as the Honda Civic Type R, it's better equipped to conquer terrain in all four seasons thanks to its all-wheel drive. Sure, its noisy operation and other obsolete attributes will cause some shoppers to spurn it, but the car's rawness and rowdiness will fascinate masochists, er, purists.",
                "https://i.pinimg.com/736x/b9/3f/c8/b93fc8c45dc5f800f7c762966685d2cb--subaru-impreza-sedan.jpg")

        )
    }
}