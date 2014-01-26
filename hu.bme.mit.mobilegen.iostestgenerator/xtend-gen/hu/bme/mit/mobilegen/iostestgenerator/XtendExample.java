package hu.bme.mit.mobilegen.iostestgenerator;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XtendExample {
  public CharSequence testFileBegin(final String fileName, final String projectName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//  ");
    _builder.append(fileName, "");
    _builder.append(".m");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#import <KIF/KIF.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@interface ");
    _builder.append(fileName, "");
    _builder.append(" : KIFTestCase");
    _builder.newLineIfNotEmpty();
    _builder.append("@end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@implementation ");
    _builder.append(fileName, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
