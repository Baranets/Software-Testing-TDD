//
//  QuickSort.swift
//  Test1
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import Foundation

class QuickSort {
    
    func sort(_ array: [Int], rootIndex: Int = 0) -> [Int] {
        guard array.count > 2 else { return array }
        let rootValue = array[rootIndex]
        
        let lessValues = array.compactMap { (value) -> Int? in
            return rootValue > value ? value : nil
        }
        
        let greaterValue = array.compactMap { (value) -> Int? in
            return rootValue < value ? value : nil
        }
        
        return lessValues + [rootValue] + greaterValue
    }
    
}
