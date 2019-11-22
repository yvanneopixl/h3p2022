//
//  WeatherResult.swift
//  WeatherApp
//
//  Created by Yvan Moté on 30/10/2019.
//  Copyright © 2019 Neopixl. All rights reserved.
//

import Foundation

struct Coordinate: Decodable {
    
    enum CodingKeys: String, CodingKey {
        case latitude = "lat"
        case longitude = "lon"
    }
    
    let latitude: Double
    let longitude: Double
}

struct Weather: Decodable {
    let id: Int
    let main: String
    let description: String
    let icon: String
}

struct Information: Decodable {
    enum CodingKeys: String, CodingKey {
        case temperature = "temp"
        case pressure
        case humidity
        case temperatureMinimum = "temp_min"
        case temperatureMaximum = "temp_max"
    }
    
    let temperature: Float
    let pressure: Int
    let humidity: Int
    let temperatureMinimum: Float
    let temperatureMaximum: Float
}

struct SunInformation: Decodable {
    let sunrise: Int  // 1 574 399 879
    let sunset: Int
    let country: String
}

struct WeatherResult: Decodable {
    
    enum CodingKeys: String, CodingKey {
        case coordinate = "coord"
        case weather
        case main
        case sunInformation = "sys"
        case name
    }
    
    let coordinate: Coordinate
    let weather: [Weather]
    let main: Information
    let sunInformation: SunInformation
    let name: String
    
}
