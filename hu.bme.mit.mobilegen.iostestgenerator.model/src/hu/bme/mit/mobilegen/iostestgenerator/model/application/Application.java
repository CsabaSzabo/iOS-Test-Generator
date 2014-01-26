/**
 */
package hu.bme.mit.mobilegen.iostestgenerator.model.application;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getUielements <em>Uielements</em>}</li>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getXcodeTestFolder <em>Xcode Test Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends EObject {
	/**
	 * Returns the value of the '<em><b>Uielements</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uielements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uielements</em>' containment reference list.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage#getApplication_Uielements()
	 * @model containment="true"
	 * @generated
	 */
	EList<UIElement> getUielements();

	/**
	 * Returns the value of the '<em><b>Xcode Test Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xcode Test Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xcode Test Folder</em>' attribute.
	 * @see #setXcodeTestFolder(String)
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage#getApplication_XcodeTestFolder()
	 * @model
	 * @generated
	 */
	String getXcodeTestFolder();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getXcodeTestFolder <em>Xcode Test Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xcode Test Folder</em>' attribute.
	 * @see #getXcodeTestFolder()
	 * @generated
	 */
	void setXcodeTestFolder(String value);

} // Application
