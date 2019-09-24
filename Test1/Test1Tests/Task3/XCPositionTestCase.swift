//
//  XCPositionTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCPositionTestCase: XCTestCase {

    var foo: Position!
    
    override func setUp() {
        foo = Position.presedent
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testPositionIsInitializedWithPresedentType() {
        XCTAssertTrue(foo == .presedent, "should be initialized with presedent state")
    }

    func testPositionRawValueIsString() {
        XCTAssertEqual(foo.description, "Presedent")
        
        foo = .engenere
        XCTAssertTrue(foo == .engenere)
        XCTAssertEqual(foo.description, "Engenere")
        
        foo = .economist
        XCTAssertTrue(foo == .economist)
        XCTAssertEqual(foo.description, "Economist")
        
        
        foo = .unowned
        XCTAssertTrue(foo == .unowned)
        XCTAssertEqual(foo.description, "Citizen")
    }
}
