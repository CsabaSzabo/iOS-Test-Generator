/**
 */
package hu.bme.mit.mobilegen.iostestgenerator.model.application.impl;

import hu.bme.mit.mobilegen.iostestgenerator.model.application.Application;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl#getUielements <em>Uielements</em>}</li>
 *   <li>{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl#getXcodeTestFolder <em>Xcode Test Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends MinimalEObjectImpl.Container implements Application {
	/**
	 * The cached value of the '{@link #getUielements() <em>Uielements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUielements()
	 * @generated
	 * @ordered
	 */
	protected EList<UIElement> uielements;

	/**
	 * The default value of the '{@link #getXcodeTestFolder() <em>Xcode Test Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXcodeTestFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String XCODE_TEST_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXcodeTestFolder() <em>Xcode Test Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXcodeTestFolder()
	 * @generated
	 * @ordered
	 */
	protected String xcodeTestFolder = XCODE_TEST_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicationPackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UIElement> getUielements() {
		if (uielements == null) {
			uielements = new EObjectContainmentEList<UIElement>(UIElement.class, this, ApplicationPackage.APPLICATION__UIELEMENTS);
		}
		return uielements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXcodeTestFolder() {
		return xcodeTestFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXcodeTestFolder(String newXcodeTestFolder) {
		String oldXcodeTestFolder = xcodeTestFolder;
		xcodeTestFolder = newXcodeTestFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.APPLICATION__XCODE_TEST_FOLDER, oldXcodeTestFolder, xcodeTestFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicationPackage.APPLICATION__UIELEMENTS:
				return ((InternalEList<?>)getUielements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplicationPackage.APPLICATION__UIELEMENTS:
				return getUielements();
			case ApplicationPackage.APPLICATION__XCODE_TEST_FOLDER:
				return getXcodeTestFolder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicationPackage.APPLICATION__UIELEMENTS:
				getUielements().clear();
				getUielements().addAll((Collection<? extends UIElement>)newValue);
				return;
			case ApplicationPackage.APPLICATION__XCODE_TEST_FOLDER:
				setXcodeTestFolder((String)newValue);
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
			case ApplicationPackage.APPLICATION__UIELEMENTS:
				getUielements().clear();
				return;
			case ApplicationPackage.APPLICATION__XCODE_TEST_FOLDER:
				setXcodeTestFolder(XCODE_TEST_FOLDER_EDEFAULT);
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
			case ApplicationPackage.APPLICATION__UIELEMENTS:
				return uielements != null && !uielements.isEmpty();
			case ApplicationPackage.APPLICATION__XCODE_TEST_FOLDER:
				return XCODE_TEST_FOLDER_EDEFAULT == null ? xcodeTestFolder != null : !XCODE_TEST_FOLDER_EDEFAULT.equals(xcodeTestFolder);
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
		result.append(" (XcodeTestFolder: ");
		result.append(xcodeTestFolder);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
