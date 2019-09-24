//
//  Planet.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class Planet: AbstractEntity {
    
    var id: String
    var name: String
    var presedent: Person? {
        didSet {
            guard presedent?.position == .presedent else {
                presedent = nil
                return
            }
        }
    }
    
    var people: [Person]
    
    init(id: String, name: String) {
        self.id   = id
        self.name = name
        self.people = []
    }
    
    func bornPerson() {
        let randomId = NSUUID().uuidString
        let randomName = NSUUID().uuidString
        let person = Person(id: randomId, name: randomName)
        people.append(person)
    }
    
}
