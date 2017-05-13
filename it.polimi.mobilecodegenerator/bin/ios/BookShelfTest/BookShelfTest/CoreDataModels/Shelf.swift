//
//  Shelf.swift
//  BookShelfTest//
//
//  Automatically generated by MobileCodeGenerator 3.
//  Copyright © 2017 . All rights reserved.
//

import Foundation
import CoreData

@objc(Shelf)
public class Shelf: NSManagedObject {
    
    @nonobjc public class func fetchRequest() -> NSFetchRequest<Shelf> {
        return NSFetchRequest<Shelf>(entityName: "Shelf")
    }
    
	@NSManaged public var name: String?
	@NSManaged public var bookCount: Int32
    @NSManaged public var hasBooks: Book?
}