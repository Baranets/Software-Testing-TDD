//
//  Test1Tests.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCSinusTestCase: XCTestCase {
        
    var sinus: Sinus!
    
    override func setUp() {
        super.setUp()
        sinus = Sinus()
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testFactorialIsNilWhenNegativeValue() {
        let result = sinus.factorial(-2)
        XCTAssertNil(result, "factorual should be nil")
    }

    func testFactorialIsOneWhenZeroValue() {
        let result = sinus.factorial(0)
        XCTAssertEqual(result, 1, "factorial should be 1")
    }
    
    func testFactorialIs120When5Value() {
        let result = sinus.factorial(5)
        XCTAssertEqual(result, 120, "factorial should be 120")
    }
    
    func testYis1WhenSinXHalfPi() {
        let y = sinus.sin(Double.pi / 2).rounded()
        XCTAssertEqual(y, 1.0, "y should be 1")
    }
    
    func testYis0WhenSinXPi() {
        let y = sinus.sin(Double.pi).rounded()
        XCTAssertEqual(y, 0.0, "y should be 0")
    }
    
    func testYisMinusZeroWhenSinXMinusPi() {
        let y = sinus.sin(-Double.pi).rounded()
        XCTAssertEqual(y, 0.0, "y should be 0")
    }

    func testYisMinus1WhenSinXMinusHalfPi() {
        let y = sinus.sin(-Double.pi / 2).rounded()
        XCTAssertEqual(y, -1.0, "y should be -1")
    }
}
