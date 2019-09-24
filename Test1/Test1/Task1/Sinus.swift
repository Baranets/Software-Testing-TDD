//
//  Sinus.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class Sinus {
    
    func sin(_ value: Double) -> Double {
        var result = 0.0
        
        for n in 0 ..< 15 {
            guard let factorial = factorial(2*n+1) else { continue }
            result += pow(-1.0, Double(n)) * pow(value, Double(2*n+1)) / factorial
        }
        
        return result
    }
    
    func factorial(_ value: Int) -> Double? {
        guard value >= 0 else { return nil }
        guard value > 0 else { return 1 }
        var result = 1.0
        for i in 1 ... value {
            result *= Double(i)
        }
        return result
    }
}
