//
//  Position.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

enum Position {
    case presedent
    case engenere
    case economist
    case unowned
    
    var description: String {
        switch self {
        case .presedent:
            return "Presedent"
        case .engenere:
            return "Engenere"
        case .economist:
            return "Economist"
        default:
            return "Citizen"
        }
    }
}
