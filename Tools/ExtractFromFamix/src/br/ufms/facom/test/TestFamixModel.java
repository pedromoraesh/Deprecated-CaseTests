package br.ufms.facom.test;
import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.ufms.facom.Diff;
import br.ufms.facom.FormatData;
import br.ufms.facom.Model;
import br.ufms.facom.model.FamixEntity;
import br.ufms.facom.model.ParameterizableClass;
import br.ufms.facom.model.Entity;

public class TestFamixModel {
	
	Model modelOld;
	Model modelNew;
	Diff diff = new Diff();

	@Before
	public void setUp() throws IOException{
		String pathNew = "C.../msefiles/spatial4j_4ec61cc4.mse";
		String pathOld = "C.../msefiles/spatial4j_74a94a1b.mse";

		Map<Integer, FamixEntity> mapOld = FormatData.mseToMap(pathOld);
		Map<Integer, FamixEntity> mapNew = FormatData.mseToMap(pathNew);
		this.modelOld = new Model();
		this.modelNew = new Model();
		modelOld.createObjects(mapOld);
		modelNew.createObjects(mapNew);
		diff.setPath("C.../results/");

	}
	
	@Test
	public void testDiff(){
		
//		diff.diffCBO(modelOld, modelNew);
//		diff.diffMethods(modelOld, modelNew);	
//		diff.diffInvocations(modelOld, modelNew);
		
		ParameterizableClass pClass = modelOld.findParameterizableClass("com.spatial4j.core.shape.BaseShape");
		
		System.out.println(pClass.getFullName());
		for(Entity entity: pClass.getSuperClass()){
			System.out.println(entity.getFullName());
		}
		
		System.out.println("-----------------------");
//
//		System.out.println(classee.getFullName());
//		for(Entity entity: classee.getSuperClass()){
//			System.out.println(entity.getFullName());
//		}
		
		
//		for(Invocation invocation: modelNew.getInvocations()){
//			if(invocation.getFullName() != null)
//			System.out.println(invocation.getFullName());
//		}
//		
//		System.out.println("-------------------------------");
//		
//		for(Invocation invocation: modelOld.getInvocations()){
//			if(invocation.getFullName() != null)
//			System.out.println(invocation.getFullName());
//		}
		
//		for(Method method: modelNew.getAllMethods()){
//			System.out.println(method.getFullName());
//		}
//		
//		System.out.println("------------------OLD----------");
//		
//		for(Method method: modelOld.getAllMethods()){
//			System.out.println(method.getFullName());
//		}
		
	}

//	@Test
//	public void testFindMethods(){
//		
//		assertEquals(modelOld.findMethods("a.b.c.TestMethods").size(), 14);
//		
//		assertEquals(modelOld.findMethods("''.AnotherClassWithoutPackage").size(), 0);
//		
//		assertEquals(modelOld.findMethods("''.ClassWithoutPackage").size(), 0);
//		
//		assertEquals(modelOld.findMethods("a.b.c.InternalClass").size(), 0);
//		
//		assertEquals(modelOld.findMethods("h.i.j.ClassWithInvocations").size(), 2);
//		
//	}
//	
//	@Test
//	public void testFindAttribute(){
//		
//		assertEquals("a.b.c.TestMethods.teste1", modelOld.findAttribute("a.b.c.TestMethods.teste1").getFullName());
//		
//		assertEquals("x.y.z.TestAttributesWithParamaterizableClass.publicListDouble", 
//						modelOld.findAttribute("x.y.z.TestAttributesWithParamaterizableClass.publicListDouble").getFullName());
//		
//	}
//	
//	@Test
//	public void testFindString(){
//		
//		assertEquals("java.lang.String", modelOld.findClass("java.lang.String").getFullName());
//		
//	}
//	
//	@Test
//	public void testFindMethod(){
//		
//		assertEquals("h.i.j.ClassWithInvocations.<init>", modelOld.findMethod("h.i.j.ClassWithInvocations.<init>").getFullName());
//		
//		assertEquals("a.b.c.TestMethods.testPrivateMethodWithParameters(java.lang.String, java.lang.Double)", 
//				modelOld.findMethod("a.b.c.TestMethods.testPrivateMethodWithParameters(java.lang.String, java.lang.Double)").getFullName());
//	}
//	
//	@Test
//	public void testAnotherClassWithoutPackage(){
//		
//		Class classe = modelOld.findClass("''.AnotherClassWithoutPackage");
//		
//		assertEquals("''.AnotherClassWithoutPackage", classe.getFullName());
//		
//		assertEquals(0, classe.getMethods().size());
//		
//		assertEquals(0, classe.getAttributes().size());
//		
//		
//		
//		assertEquals(1, classe.calculateCBO().size());
//		
//	}
//	
//	@Test
//	public void testClassWithoutPackage(){
//		
//		Class classe = modelOld.findClass("''.ClassWithoutPackage");
//		assertEquals("''.ClassWithoutPackage", classe.getFullName());
//		
//		assertEquals(0, classe.getMethods().size());
//		
//		assertEquals(0, classe.getAttributes().size());
//		
//		
//		
//		assertEquals(1, classe.calculateCBO().size());
//	}
//	
//	@Test
//	public void testTestMethods(){
//		
//		
//		Class classe = modelOld.findClass("a.b.c.TestMethods");
//		
//		assertEquals(classe.getFullName(), "a.b.c.TestMethods");
//		
//
//		Method method = classe.findMethod("a.b.c.TestMethods.testPrivateMethodWithoutParameter()");
//		assertEquals(method.getFullName(), "a.b.c.TestMethods.testPrivateMethodWithoutParameter()");
//		
//		assertEquals(4, classe.getAttributes().size());
//		
//		assertEquals(1, method.getLocalVariables().size());
//
//		assertEquals(2, method.getListInvocation().size());
//		
//		assertEquals("teste2.intern()", method.getListInvocation().get(0).getSignature());
//		
//		assertEquals("teste1.trim()", method.getListInvocation().get(1).getSignature());
//		
//		assertEquals(1, method.calcCBOWithLocalVariables().size());
//		
//		Method method2 = classe.findMethod("a.b.c.TestMethods.testPrivateMethodWithParameters(java.lang.String, java.lang.Double)");
//		
//		assertEquals("a.b.c.TestMethods.testPrivateMethodWithParameters(java.lang.String, java.lang.Double)", method2.getFullName());
//		
//		assertEquals(2, method2.getListInvocation().size());
//		
//		assertEquals(2, method2.calcCBOreturnAndParameters().size());
//		
//		assertEquals("teste2.toLowerCase()", method2.getListInvocation().get(0).getSignature());
//		
//		assertEquals("teste1.toUpperCase()", method2.getListInvocation().get(1).getSignature());
//						
//		assertEquals(10 ,classe.calculateCBO().size());
//				
//	}
//	
//	@Test
//	public void testInternalClass(){
//		
//		Class classe = modelNew.findClass("a.b.c.InternalClass");
//		
//		assertEquals("a.b.c.InternalClass", classe.getFullName());
//		
//        assertEquals(0, classe.getMethods().size());
//		
//		assertEquals(0, classe.getAttributes().size());
//		
//		assertEquals(12, classe.calculateCBO().size());
//			
//		Class classe1 = modelOld.findClass("a.b.c.InternalClass.PublicInternalClass1.PublicInternaClass2.PublicInternalClass3.PublicInternalClass4");
//		
//		assertEquals("a.b.c.InternalClass.PublicInternalClass1.PublicInternaClass2.PublicInternalClass3.PublicInternalClass4", classe1.getFullName());
//	}
//	
//	@Test
//	public void testClassWithInvocations(){
//		
//		Class classe = modelOld.findClass("h.i.j.ClassWithInvocations");
//		
//		assertEquals("h.i.j.ClassWithInvocations", classe.getFullName());
//		
//		assertEquals(2, classe.getMethods().size());
//		
//		assertEquals(5, classe.findMethod("h.i.j.ClassWithInvocations.<init>").getListInvocation().size());
//		
//		assertEquals(0, classe.findMethod("h.i.j.ClassWithInvocations.<init>").calcCBOreturnAndParameters().size());
//		
//		assertEquals("new TestAttributes()", classe.findMethod("h.i.j.ClassWithInvocations.<init>").getListInvocation().get(0).getSignature());
//		
//		assertEquals("methods.testPublicMethodPrimitiveReturnWithParameters(\" \",tAttributes)", classe.findMethod("h.i.j.ClassWithInvocations.<init>").getListInvocation().get(1).getSignature());
//		
//		assertEquals(7, classe.calculateCBO().size());
//		
//	}
//	
//	@Test
//	public void testLocalVariables(){
//		
//		Class classe = modelOld.findClass("h.i.j.LocalVariables");
//		
//		assertEquals("h.i.j.LocalVariables", classe.getFullName());
//		
//		assertEquals(1, classe.getMethods().size());
//		
//		assertEquals(0, classe.getAttributes().size());
//		
//		assertEquals(5, classe.findMethod("h.i.j.LocalVariables.methodWithLocalVariables()").getLocalVariables().size());
//		
//		assertEquals(1, classe.calculateCBO().size());
//		
//		
//	}
//	
//	@Test
//	public void testTestAttributesWithParameterizableClass(){
//		
//		Class classe = modelOld.findClass("x.y.z.TestAttributesWithParamaterizableClass");
//		
//		assertEquals("x.y.z.TestAttributesWithParamaterizableClass", classe.getFullName());
//		
//		assertEquals(2 ,classe.getMethods().size());
//		
//		assertEquals(4, classe.getAttributes().size());
//				
//		assertEquals(6, classe.calculateCBO().size());
//		
//	}
//	
//	@Test
//	public void testTestAttributes(){
//		
//		Class classe = modelOld.findClass("x.y.z.TestAttributes");
//		
//		assertEquals("x.y.z.TestAttributes", classe.getFullName());
//		
//		assertEquals(1, classe.getMethods().size());
//		
//		assertEquals(4, classe.calculateCBO().size());
//		
//	}
//	
//	@Test
//	public void testFindInvocations(){
//		
//		assertEquals("java.lang.String.trim()", 
//				modelOld.findInvocation("java.lang.String.trim()").getFullName());
//		
//		assertEquals("java.lang.String.toLowerCase()", 
//				modelOld.findInvocation("java.lang.String.toLowerCase()").getFullName());
//	}
	

}
