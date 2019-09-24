//
//  Spaceship.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class Spaceship: AbstractEntity {
    
    var id: String
    var name: String
    var location: Location
    var personal: [Person]
    
    init(id: String, name: String,
         location: Location = Location(x: Double.random(in: 0...100).rounded(),
                                       y: Double.random(in: 0...100).rounded(),
                                       z: Double.random(in: 0...100).rounded()))
    {
        self.id = id
        self.name = name
        self.location = location
        self.personal = []
    }
    
    func warp(to location: Location) throws {
        if self.location != location {
            self.location = location
        } else {
            throw WarpError.sameLocation
        }
    }
    
    func recruit(_ person: Person) throws {
        if person.position == .engenere {
            personal.append(person)
        } else {
            throw RecruitingError.notEngenere
        }
    }
    
}

public struct Location: Equatable {
    var x,y,z: Double
}

enum WarpError: Error {
    case sameLocation
}

enum RecruitingError: Error {
    case notEngenere
}
