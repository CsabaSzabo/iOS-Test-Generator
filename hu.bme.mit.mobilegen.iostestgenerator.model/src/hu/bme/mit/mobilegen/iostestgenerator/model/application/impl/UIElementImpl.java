/**
 */
package hu.bme.mit.mobilegen.iostestgenerator.model.application.impl;

import hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.UIElementImpl#getAccessibilityLabel <em>Accessibility Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UIElementImpl extends MinimalEObjectImpl.Container implements UIElement {
	/**
	 * The default value of the '{@link #getAccessibilityLabel() <em>Accessibility Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessibilityLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCESSIBILITY_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessibilityLabel() <em>Accessibility Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessibilityLabel()
	 * @generated
	 * @ordered
	 */
	protected String accessibilityLabel = ACCESSIBILITY_LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicationPackage.Literals.UI_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccessibilityLabel() {
		return accessibilityLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessibilityLabel(String newAccessibilityLabel) {
		String oldAccessibilityLabel = accessibilityLabel;
		accessibilityLabel = newAccessibilityLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.UI_ELEMENT__ACCESSIBILITY_LABEL, oldAccessibilityLabel, accessibilityLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplicationPackage.UI_ELEMENT__ACCESSIBILITY_LABEL:
				return getAccessibilityLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicationPackage.UI_ELEMENT__ACCESSIBILITY_LABEL:
				setAccessibilityLabel((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ApplicationPackage.UI_ELEMENT__ACCESSIBILITY_LABEL:
				setAccessibilityLabel(ACCESSIBILITY_LABEL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ApplicationPackage.UI_ELEMENT__ACCESSIBILITY_LABEL:
				return ACCESSIBILITY_LABEL_EDEFAULT == null ? accessibilityLabel != null : !ACCESSIBILITY_LABEL_EDEFAULT.equals(accessibilityLabel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accessibilityLabel: ");
		result.append(accessibilityLabel);
		result.append(')');
		return result.toString();
	}

} //UIElementImpl
