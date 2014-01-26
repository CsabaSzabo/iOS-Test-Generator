package hu.bme.mit.mobilegen.iostestgenerator

class XtendExample {
		def testFileBegin(String fileName, String projectName)'''
//  «fileName».m

#import <KIF/KIF.h>

@interface «fileName» : KIFTestCase
@end

@implementation «fileName»
'''
}