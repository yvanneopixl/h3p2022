//
//  ViewController.swift
//  WeatherApp
//
//  Created by Yvan Moté on 30/10/2019.
//  Copyright © 2019 Neopixl. All rights reserved.
//

import UIKit
import CoreLocation
import AlamofireImage

class ViewController: UIViewController {

    @IBOutlet weak var placeNameLabel: UILabel!
    @IBOutlet weak var weatherImageView: UIImageView!
    @IBOutlet weak var sunriseLabel: UILabel!
    @IBOutlet weak var sunsetLabel: UILabel!
    @IBOutlet weak var minimumTemperatureLabel: UILabel!
    @IBOutlet weak var maximumTemperatureLabel: UILabel!
    
    lazy var locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        self.placeNameLabel.text = nil
        self.minimumTemperatureLabel.text = nil
        self.maximumTemperatureLabel.text = nil
        self.sunriseLabel.text = nil
        self.sunsetLabel.text = nil
        
        locationManager.delegate = self
        
        if CLLocationManager.authorizationStatus() == .authorizedWhenInUse {
            locationManager.requestLocation()
        } else {
            locationManager.requestWhenInUseAuthorization()
        }
    }
}

extension ViewController: CLLocationManagerDelegate {
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        
        if status == .authorizedWhenInUse {
            locationManager.requestLocation()
        }
        
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("didFailWithError: \(error)")
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        if let location = locations.first {
            let coordinate = location.coordinate
            WeatherService.retrieveWeather(latitude: coordinate.latitude, longitude: coordinate.longitude) { (result) in
                
                self.placeNameLabel.text = result.name
                
                self.minimumTemperatureLabel.text = "\(result.main.temperatureMinimum) °C"
                self.maximumTemperatureLabel.text = "\(result.main.temperatureMaximum) °C"

                let dateFormatter = DateFormatter()
                dateFormatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"
                dateFormatter.dateFormat = "HH:mm:ss"

                let sunriseDate = Date(timeIntervalSince1970: Double(result.sunInformation.sunrise))
                let sunsetDate = Date(timeIntervalSince1970: Double(result.sunInformation.sunset))

                self.sunriseLabel.text = dateFormatter.string(from: sunriseDate)
                self.sunsetLabel.text = dateFormatter.string(from: sunsetDate)

                if let weather = result.weather.first {
                    let imageUrl = iconUrl(icon: weather.icon)
                    
                    if let url = URL(string: imageUrl) {
                        self.weatherImageView.af_setImage(withURL: url)
                    }
                }
            }
        }
    }
}

