//
//  XCQuickSortTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCQuickSortTestCase: XCTestCase {

    var quickSort: QuickSort!
    
    override func setUp() {
        super.setUp()
        quickSort = QuickSort()
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testReturnEquelArrayWhenSortEmptyArray() {
        let foo: [Int] = []
        
        let sortedArray = quickSort.sort(foo)
        
        XCTAssertEqual(sortedArray, foo, "arrays should be equel")
    }
    
    func testReturnEquelArrayWhenSortArrayWithOneElement() {
        let foo: [Int] = [6]
               
        let sortedArray = quickSort.sort(foo)
        
        XCTAssertEqual(sortedArray, foo, "arrays should be equel")
    }
    
    func testReturnSortedArrayWhenSort() {
        let foo: [Int] = [3, 2, 1]
        
        let sortedArray = quickSort.sort(foo, rootIndex: 1)
        
        XCTAssertEqual(sortedArray, [1, 2, 3], "arrays should be equal")
    }
    
    func testReturnsSameValuesWhenSort() {
        let foo: [Int] = [0, 1, 5, 3, 2, 6, 7, 9, 8]
        
        let sortedArray = quickSort.sort(foo, rootIndex: 2)
        
        XCTAssertEqual([0, 1, 3, 2, 5, 6, 7, 9, 8], sortedArray)
        XCTAssertEqual(foo.count, sortedArray.count, "array should have")
        for value in sortedArray {
            XCTAssertTrue(foo.contains(value), "array should contains same values")
        }
    }

}
