/**
 */
package hu.bme.mit.mobilegen.iostestgenerator.model.application;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement#getAccessibilityLabel <em>Accessibility Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage#getUIElement()
 * @model
 * @generated
 */
public interface UIElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Accessibility Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessibility Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessibility Label</em>' attribute.
	 * @see #setAccessibilityLabel(String)
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage#getUIElement_AccessibilityLabel()
	 * @model
	 * @generated
	 */
	String getAccessibilityLabel();

	/**
	 * Sets the value of the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement#getAccessibilityLabel <em>Accessibility Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessibility Label</em>' attribute.
	 * @see #getAccessibilityLabel()
	 * @generated
	 */
	void setAccessibilityLabel(String value);

} // UIElement
