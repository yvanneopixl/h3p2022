//
//  WeatherService.swift
//  WeatherApp
//
//  Created by Yvan Moté on 30/10/2019.
//  Copyright © 2019 Neopixl. All rights reserved.
//

import Foundation
import Alamofire

class WeatherService {
    
    typealias Result = (_ result: WeatherResult) -> Void
    
    static func retrieveWeather(latitude: Double, longitude: Double, callback: @escaping Result) {
        let url = "https://api.openweathermap.org/data/2.5/weather?lat=\(latitude)&lon=\(longitude)&units=metric&appid=ffcc384993c489a7eff30caec22de8dd"
                
        Alamofire.request(url).responseData { (response) in
            switch response.result {
            case .success(let value):
                
                let jsonDecoder = JSONDecoder()
                
                do {
                    let weatherResult = try jsonDecoder.decode(WeatherResult.self, from: value)
                    callback(weatherResult)
                } catch let error {
                    print("error while deconding: \(error)")
                }
                
                break
            case .failure(let error):
                print("error network: \(error)")
                break
            }
        }

    }
    
}
