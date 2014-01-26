/**
 */
package hu.bme.mit.mobilegen.iostestgenerator.model.application;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationFactory
 * @model kind="package"
 * @generated
 */
public interface ApplicationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "application";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://application/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "application";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplicationPackage eINSTANCE = hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Uielements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__UIELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Xcode Test Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__XCODE_TEST_FOLDER = 1;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.UIElementImpl <em>UI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.UIElementImpl
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl#getUIElement()
	 * @generated
	 */
	int UI_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Accessibility Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__ACCESSIBILITY_LABEL = 0;

	/**
	 * The number of structural features of the '<em>UI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>UI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getUielements <em>Uielements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uielements</em>'.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getUielements()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Uielements();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getXcodeTestFolder <em>Xcode Test Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xcode Test Folder</em>'.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.Application#getXcodeTestFolder()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_XcodeTestFolder();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement <em>UI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Element</em>'.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement
	 * @generated
	 */
	EClass getUIElement();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement#getAccessibilityLabel <em>Accessibility Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accessibility Label</em>'.
	 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement#getAccessibilityLabel()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_AccessibilityLabel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ApplicationFactory getApplicationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl
		 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Uielements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__UIELEMENTS = eINSTANCE.getApplication_Uielements();

		/**
		 * The meta object literal for the '<em><b>Xcode Test Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__XCODE_TEST_FOLDER = eINSTANCE.getApplication_XcodeTestFolder();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.UIElementImpl <em>UI Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.UIElementImpl
		 * @see hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl#getUIElement()
		 * @generated
		 */
		EClass UI_ELEMENT = eINSTANCE.getUIElement();

		/**
		 * The meta object literal for the '<em><b>Accessibility Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__ACCESSIBILITY_LABEL = eINSTANCE.getUIElement_AccessibilityLabel();

	}

} //ApplicationPackage
