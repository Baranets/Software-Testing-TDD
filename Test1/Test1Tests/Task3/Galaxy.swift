//
//  Galaxy.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class Galaxy: AbstractEntity {
   
    var id: String
    var name: String
    var spaceships: [Spaceship]
    var planets: [Planet]
    
    init(id: String, name: String) {
        self.id = id
        self.name = name
        self.spaceships = []
        self.planets = []
    }
    
    func launchSpaceship(_ spaceship: Spaceship) throws {
        if spaceship.personal.count > 0 {
            spaceships.append(spaceship)
        } else {
            throw SpaceshipError.noPersonal
        }
    }
    
    func generatePlanet() {
        let planet = Planet(id: UUID().uuidString, name: UUID().uuidString)
        planets.append(planet)
    }
    
}

enum SpaceshipError: Error {
    case noPersonal
}
