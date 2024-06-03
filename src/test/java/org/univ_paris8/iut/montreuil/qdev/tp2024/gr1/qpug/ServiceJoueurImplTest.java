package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock.NamePlayerVideMock;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock.PseudoPlayerNonUniqueMock;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock.PseudoPlayerOkMock;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.PseudoPlayerVideMock;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonUniquePseudoException;

import java.util.ArrayList;


public class ServiceJoueurImplTest {
  private ServicePlayerInterface servicePlayerImpl;

  @BeforeEach
  void setUp(TestInfo testInfo) throws Exception {
    servicePlayerImpl = null;
    System.out.println("test " + testInfo.getDisplayName());
  }


  @Test
  void setPseudoPlayerValideTest(){
      servicePlayerImpl = new PseudoPlayerOkMock();
      ProfileDTO profileAttendu = new ProfileDTO("baptiste", "bati", 2002, "manger, annoncer la pluie", LangEnum.francais, new ArrayList<>());

      try{
        ProfileDTO profileResultat = servicePlayerImpl.createNewProfile("baptiste", "bati", 2002, "manger, annoncer la pluie", LangEnum.francais, new ArrayList<>());
        assertEquals(profileAttendu, profileResultat, "création d'un profile avec un pseudo valide");

      }catch(Exception e){
        System.out.println(e);
      }
  }
  @Test
  void setPseudoPlayerVideTest(){
      servicePlayerImpl = new PseudoPlayerVideMock();
      try{
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{servicePlayerImpl.createNewProfile("baptiste", "", 2002, "manger, annoncer la pluie", LangEnum.francais, new ArrayList<>());});
      }catch (Exception e){
        System.out.println("Erreur inattendue dans le test");
      }

  }

  @Test
  void setPseudoPlayerNonUniqueTest(){
    servicePlayerImpl = new PseudoPlayerNonUniqueMock();
    try{
      NonUniquePseudoException e = assertThrows(NonUniquePseudoException.class, ()->{servicePlayerImpl.createNewProfile("baptiste", "", 2002, "manger, annoncer la pluie", LangEnum.francais, new ArrayList<>());});
    }catch (Exception e){
      System.out.println("Erreur inattendue dans le test");
    }

  }

  @Test
  void setNamePlayerVideTest(){
    servicePlayerImpl = new NamePlayerVideMock();
    try{
      IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{servicePlayerImpl.createNewProfile("", "bati", 2002, "manger, annoncer la pluie", LangEnum.francais, new ArrayList<>());});
    }catch (Exception e){
      System.out.println("Erreur inattendue dans le test");
    }

  }

  void setNamePlayerValidTest(){

  }

  void setInterestPlayerVideTest(){

  }

  void setInterestPlayerValideTest(){}

  void setLangueNotEnumTest(){

  }

  void setLangueValideTest(){

  }

  void setBirthYearValideTest(){}

  void setBirthYearInvalideTest(){}
}

