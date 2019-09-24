//
//  Person.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class Person: AbstractEntity {

    var id: String
    var name: String
    var position: Position?
    
    init(id: String, name: String) {
        self.id = id
        self.name = name
    }
    
    func tag() -> String {
        return getFullIdentifier() + " " + (self.position?.description ?? "")
    }
    
}
