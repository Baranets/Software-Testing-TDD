//
//  AbstractEntity.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

protocol AbstractEntity: Equatable {
    
    var id:   String { get set }
    var name: String { get set }
    
    func getFullIdentifier() -> String
    
}

extension AbstractEntity {
    
    static func == (lhs: Self, rhs: Self) -> Bool {
        return lhs.id == rhs.id && lhs.name == rhs.name
    }
    
    func getFullIdentifier() -> String {
        return id + " " + name
    }
    
}
