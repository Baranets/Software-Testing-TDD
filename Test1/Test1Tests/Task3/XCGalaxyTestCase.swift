//
//  XCGalaxyTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCGalaxyTestCase: XCTestCase {

    var sut: Galaxy!
    
    override func setUp() {
        sut = Galaxy(id: "foo", name: "bar")
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testLaunchingSpaceshipWithPersonal() {
        let spaceship = Spaceship(id: UUID().uuidString,
                                  name: UUID().uuidString)
        let person = Person(id: UUID().uuidString,
                            name: UUID().uuidString)
        spaceship.personal.append(person)
        
        do {
            XCTAssertNoThrow(try sut.launchSpaceship(spaceship))
        }
        
        XCTAssertTrue(sut.spaceships.contains(spaceship))
    }
    
    func testLaunchingSpaceshipWithoutPersonalThrows() {
        let spaceship = Spaceship(id: UUID().uuidString,
        name: UUID().uuidString)
        do {
            XCTAssertThrowsError(try sut.launchSpaceship(spaceship))
        }
    }
    
    func testGenerateNewPlanet() {
        let oldPlanetCount = sut.planets.count
        
        sut.generatePlanet()
        let newPlanetCount = sut.planets.count
        
        XCTAssertGreaterThan(newPlanetCount, oldPlanetCount)ç
    }

}
