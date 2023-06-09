APCSAFinalProject/ROADMAP.md                                                                        0000644 0001750 0001750 00000000736 14437415125 014273  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   # ROADMAP

## short term

- ~~implement admin account that can access other users (change password, delete account, etc.)~~ (**REMOVED, thought it was pointless**)

## long term

- ~~file management (saving all accounts/emails to file) so that things save between runs~~ (**DONE!**)

- event logger, save to file?

- find way to run on website/host on server, make actually kinda accessible email server?

---

### - [oicleevan](https://github.com/oicleevan)
([back to home](/))                                  APCSAFinalProject/build.xml                                                                         0000644 0001750 0001750 00000001544 14440117337 014503  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   <?xml version="1.0"?>
<project name="APCSAFinalProject" default="package">
	<description>
		a simple psuedo-emailserver written in java for a csa project.
	</description>

	<property name="src" location="src/"/>
	<property name="build" location="build/"/>
	<property name="dist" location="dist/"/>

	<target name="compile" description="compiles the source">
		<mkdir dir="${src}"/>
		<mkdir dir="${build}"/>
		<javac srcdir="${src}" destdir="${build}"/>
	</target>

	<target name="package" depends="compile" description="builds to executable jar file">
		<jar jarfile="${dist}/${ant.project.name}.jar" basedir="${build}">
			<manifest>
				<attribute name="Main-Class" value="Main"/>
			</manifest>
		</jar>
	</target>

	<target name="clean" description="cleans, gets rid of build files and stuff">
		<delete dir="${build}" failonerror="false"/>
	</target>
</project>
                                                                                                                                                            APCSAFinalProject/dist/                                                                             0000755 0001750 0001750 00000000000 14436125176 013626  5                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   APCSAFinalProject/dist/data/                                                                        0000755 0001750 0001750 00000000000 14440117010 014516  5                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   APCSAFinalProject/dist/data/save.txt                                                                0000644 0001750 0001750 00000002645 14440117010 016224  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   �� sr EmailAccount        L email_addresst Ljava/lang/String;L emailst Ljava/util/ArrayList;L nameq ~ L passwordq ~ xpt evansr java.util.ArrayListx����a� I sizexp   w   sr Email        L messageq ~ L sendert LEmailAccount;xpt ;This is a test message to show that the email system works!q ~ sq ~ t 
no bitchessq ~  t nobodysq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ xt nobodyt nobodysq ~ t $sup evan cool program youre so smartsq ~  t evansucks24jkLOLsq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ xt valeriet nabilisatryhardsq ~ t hi evansq ~  t ethananderssonsq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ xt Ethant hellosq ~ t dsyufgdiughsfdsq ~  t ____sq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ (xt Mt LOLxt Evant evanoicle05sq ~  t andreisq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ 1sq ~ t AHello andrei, I hope you are enjoying using my email accounts. :)q ~ xt Andreit 123456sq ~  t bob3sq ~    w   sq ~ t ;This is a test message to show that the email system works!q ~ :xt bobt bob1q ~ sq ~  t fellowsalmonsq ~    w   sq ~ q ~ q ~ Axt Brendat salmon^2q ~ sq ~  t nullsq ~    w   sq ~ q ~ q ~ Gxt Nabil Mausjt oaisjd-ajisdaojsq ~ q ~ (                                                                                           APCSAFinalProject/dist/APCSAFinalProject.jar                                                        0000644 0001750 0001750 00000021305 14440114354 017444  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   PK
    )V�V            	  META-INF/��  PK
   (V�VeA�|x   �      META-INF/MANIFEST.MF�M��LK-.�K-*��ϳR0�3��r�Cq,HL�HU �%��x���RKRSt�*�:���̵�uC�J�JJuJ�����������F@QfP��SifN�&/�obf��sNbq������� PK
   �U�V�<���  n     Email.class�T�RA=�ۆ�\An�p�PQ�)4�U >�ː�aa���]��ُ�^�J��>�o�,��n�@��ڞ�ޞs��t�ן�G Ƒ������ B��u�%ua����ˬC�i��L���J¨RQq*!8S�NP
ҶE^��S�%�Ҍ����FE-�̖FNZ����u2�57g4�(��S�Р�QE���SBcN��k��7~�*���/��|�V7�Fh*��6��p^i��lG�MxP��EW�v���SI�EW��RЭ���l>8�y�,�g4���C��Kf+�>��K�Q��d�[3���	]{/Vu�Pg{�iٚi���&�SB�I�V��)�(=D�����
!�6s)������;�\rDvcA�]f�	�.�v̓���2M�v,Q\�Κ��kC��a\����G��S��27d�T�"��6��Y����0r���2���Y��ҿm\�.�
�gUj�s�R�H]_��U<�B�F�3Ga�g-�0�N�qJDJ]8�+P�CZi]ض���/u2|�m��>.��{�ǵ��-�� ��|��/�#�9�>�~���;����xx�M~%S�P�}���T*!�Eo9�-���5��%z� ���QhU���]C���E�p�!к�X�!0t��X���_��q��{�=���Q��1W���;{���pvxb��>�-wp��<�><d��}��)�Nc��Dx��x���PK
   ;U�V#�J\O  �     EmailAccount.class�V�wW��-{��:Q��m�n�G%ۉ)PH#7i⦍����8�F��7Z�*ڕ�G�-��)چ�3�8��:P���g~���f�;=��ٽ{��ܙo��{_���� ���t��]C�@:��Ykȱ��#'N�B �9l�v�O�=���B]t�0�Ce�v
^�%јk��@2w�J>���t���X�J=����Ū�}^Yg �+���s^��a�@��Rlg�@�j��l?�ыvV�����H�)c���\q�w3ޤ�6[XZW��ƚȏ�{�M���
��#��܍pd��u�}���^��@���RÝ�~i����7�o����L�Z��<ӟ���`�
�!M�����,�|�ߪc'8#��R���-�=��`�v)%UY���T"�a*΄�{����m$�����D�o�;4�1p���A^yF�x��	����+9$�r&�a�ÓE�Q�|Ye6��I�]�U�s�y�F1֜��إ�I��B o��}د�>p����;
h�r��!����~��X��^��>`�A�ءt�����N�6��.�P�`���ft�bL��x���U�ZW�	r�K�_�J��E'��1�~���3�N��V��Lo�[�i�D7�U�Ԭ���&�[�X��n��όy��{9&mZcd%I���n)[%9�+����������ǫ��8A8���݌|�s)�OIMp�M��M=ħbR�&��@�rX1��^�<T(6Ace�����l4��F���@�ԦV�3�?F�Tg�3�q����^��(.��0é���񪜵�\����G�Leo��6�CvM�mV�I�/2�7�	Ǔݔ�	&B��oG*�Mg��|��h}r��q|�r�O*j0I��mh_�HT7��爩G�+D'��jm�&:ځ9g;�y�f��8�@����/�K�1�e��}�f9~�x�zN`O�Fw3�q�?g�|�t=r�M"�g��}������V֭�m�����g�#pk��HzB��(덵����Y�C,M��s�����ǲ�r�CT�z���d���ӮԪ���Ձ5u�}�{n
�V���:�eȐF���V>�l�ݾƣ#����=��*�F���0P�iq(:j{
3�P��ز'���fݓUg�5r.8ѕ"q��?�Z�Q�xEm'���9~��e��/�_�m��^IF[����@u;/��r'"���a�-:�ߞ�R����PdƷ�E[mb�r�<�$��_���U�%˯"�W�]ST�3֬4EXr)?�;��Q���6��E_#Cc�4�Mƌ.Qj�T|�>b���iġI�w�qS�h���E��Ba�(ũ�	|6��������C<ŧ��5Q��F�z�|Q�t�#����C�\��Oh�~�轧�2D��"���E���ZD��*z�.c�"������'�`��J�H�fv]ˎO���:zzw���h��-�{��.�v��P�@lw]��_��h��}�;��Dc��֟�X8���Nf�W�x4Rǡ�#7:x����n�� ��W�����q$C�u_�� ��x9ܱ�]1[J�n�,\T.,�0��]C�v��{b�S_�N�0��/5��G~?CFY���K8�v�>�!v16~�G_�i�籍s���1��L�|p	QzOq����ُ���Xd�
�������I~��S��u<}��+��~=�b��]BC��H�Ke�E,F1l����M�~!J�f�}Qru�yq	w5��7eL:�Xj}��4Y�WTL��M6mT�",�-��%|YǕ��Md�k�btj_��o]���\^R�v`	%?���U�W���x]Ք��g��PK
   �U�VP��c�  �     EmailUtils.class�V�wG�F����y)IS[8٤Il+����v�I5�P�[h����x����W�����(��Àq@q(�U�����zwfW�e�=����ܹ��~��}��� x ��#���6�3l�����n������C��a�C���|Q��Ut@m�U]��HʮХ�Yyb�g��r����P���ͼ]�gk^�k�K�aj.�*e����U��؊m
*�c������eZd�7����g���GqC�E��hz>oW,���*.w,��5a�n��@D��#�w(�V�{�ҳs�K��p�n�s���}�F���C��I���F��d���8H6��;o;_�WE�lX�+8DץC��X�H��Z?��-�;;�w2��r�� )����疖'�=^����x�`IL���(���hfZ��mޮ��4fen���nٔ�F
ҚW-s���ݞ��iq4o�<-���`�0M-o[y�R��1��*���!���ݏCPe ��-�;CqaX�*F|�6H0D-~����~b)ُcc
>��8N4sY�C��Wt��&���1�7)\;�"��H�`~�^b#�	*���qL0�*�|��ӽ�W����G6�"q+��!�D���z��g��r
Ϊ8�����(s��%q���{6ArW��R&�u�a\T0��<Jm��#~L��+L�Q�.1�Yr��8���T�E���(�� g���V<^K�V��:.�F�.�qY�,L����ֹ������Ra�:ȣzun<������3��D��`�*]�`k�o��{�"���Z�v��N�/�9�°)_����=��@2}�q|S�q��'�<�2��3��e�q9�|���Q�$Þ;��wN�9y�J��=ö��?-P���%�i�k�U�4���Hڍ��(>�@��L��K���	#M/D?X�����E�J�'�=v�����⪇1�7z������ �GxE4�+u��oS�������a8r����)�i��+v�a_��w������	4??����O�xv\�$���e-719�0��M�Mj���_����:��o]�xAŋx��ɭ�(1#~��'"�1�2���Oix�9�꟱��y�"���ES���Q��ʕ����b�����ޖ"}�cb9c�ҽ�C��@�
n�zd�:Ę] ����]����z��>e��f9\��ɋ���JW��my�������Cf�m{�^�D�����q����A�+4��ϰ��Y��o�'�<��*�sk�JO�V�����m�V�o=��.����B��h��1�4s��^����٢n���<m;Z�hۮlo��i�Ǵ^��_��l=�d�Ц�DRT<lP#e�<3�T���������2�~kQb�/��T\!�a��|�U\|�;&�;͌_�:�%�e�ӕ����m����H�����ϐh��e(�M5l�5�ZA�)���z_V��u��M�.J�o =!�����%��JGkL���c�о@���l��@�2�uz*G��\���-~G���e�ރB�i�O���졗q��*4Z|��U���<]��^EA�]��oڪa掁���&� ��& 0.���=��M̐��P���"�^"3l�aAE�(da�-�8h��G�8z|D��)	Ig�yD���K���m�VPYl[l��	�w*�BK�7��K�-B�#���HzՑDۺ�^@�;�"�BsWr����J��E��fb���ߦ�m�����'X��gy���dN���T�Y龚J|^"!��E�K��f�;I����З��W׷�/_�|�'֒XS@&@��oS^��z]d I��6x�g�m]{��z���Bo��4�@���;NR�Vx�T��VÏ,(�O1�p�?k����-JZ75�G�؞X��ob��2~v��q�/�V��e��G���|���^�?�::�PK
   �R�V۴:�D  �     FileManagement.class�T]SU~lrBX�|��X,X)��Z�&6����K�҅d7���O��[�ITf�/���J�i|���Bg���=�y?��y�s�z��o n��G�%x.�jO�pN3w�kۻz����a��OLnH�T��(�W����;'���e�;���D؏\��Uч��JuOO��3�����<8k�҃*.����e���⃀��|Е�t�֓�SF+�@�i����^�����0FT��"�)��nk����e��(�$�Qq�6�˶�/X��C�(h�d��;�c���EZ+��2e$(y?&1%1�"��@7�'4S���I�z�7����3����7�')��.�/�7�z��m�!p�a�w��nr�����fj$�𑊏qK�gغ��K��Ƒ$�ڣ��bNⶊy�C�Y�X+%�}�}�X�"	i�A`���i����-�5#���ʦ��WT|���O-B՘ۖat��VU|�}�dr���ҭJ$�%ޱ���H`���K_9���S�K�ݛ{��Ŏ�M���ɚ��}�%ܑ-���#-�i|����$�7y8\�x��[V�O�l=��6��Y^[i"3��
�Ѡj��kD�b諜}����s�g��n�<*K�,-]�IhŔ��c�[Ҟ��R���N�3��s���X7vL�.[y���x�4D�Dj��eW�B�b��������La�v�S�)����v��
Z=SU�#ǡ��{|���i�>�L�KG���S+�n�A�
6�+�<�/����!�vP�k�h	�)�m5ڶI�Hj��V��D� q�?����!e����1��S?cB���1f��*>H��lD	(� "�c�����X�xBO��G�/�8��� F��.��#��,0���p����3�F�uЎ��$�1��`>~��([
����/�:/�#�|d��D=���stc4]�����Tz����1��P"�2��<�MA��
2K�<���� �̐���Y�A����xL��!�H�f���.=.�g��M*\E�'mڂ�?Q�j��җ�)�4�Hlh5��h��TY$}:j����us�]W��PK
   )V�VDW|�N  �     Main$1.classmPMO1}u��u�TP�;� �xFM�hz�x0�m`��M����ҋƃ?�e�������޼������{`�H�XD��8�s�\���8�gH2�'V�1� Ð���sq�t�l�.r�38�)���!/����Lj��t����8��@閃"J6�.��B�� =.�HL��%�uu?C����24���Y�u�Q��捁�*����?dH�#��V<�����"rO�q��� �����6� ��ۿr�C�R(})�ҽ�R��+%vQ!k�1���*e%���i��=% ����!�r�l?#���7��:�j��NҳF
 ����/PK
   )V�VQB�d    
   Main.class�W�S���k�ehu؆�ndl킴D��$Z�Fa����nvv���2��9���-'q���Q	%h���c\���� **��eA��Us�~�^������?���w O`=�:�h0ш&���bA�9�{v��,�M�m��d�Og&H0�D(�� ��R�D-L{���:d;rT�bV��K'�!�+��Lzd+G>�mw6��MQh;}��/�G� �5�{�L��~��`I����P�^���!�"������&P�3u���%��i%2o�,���|�ăx�a��/��]��'geX{8�Ό����"�F��vK��^��6�eh��/F��-�g=oN�c��Ka�2I��1�c�W͹A�ch)8R���/��<��Ȫ�� ~HHG���8n�1��c'��A(K��^֐����~H[ EI�}�ć�Z��t��έJmN���4�}%1'<� vX�;��ލG���MI<��|�D?�fط����zrܻ�ڌJ�<�X�Ţ��9_�"��s�������ҽ'C ]�{>W`sM���~�!'x�\���,>-g<_�ke��~ǲ| vr��W:����Y�W��}Z��*%���E*��w�Ҵ��7�.���g����rEe.��%��U����,.����a����B���ak�0I|��F�LD�	��ְ*����pf8�S�鼉��Feŵ��q<OǛU�h'�o��\��EZ
d��牲�$�.f�S�E��=TyN�����Q���&>��I�O�1hd~��KT������_+�&ZA
������|kǌ�Y)�F��q����w�E��l���Ω��(`%�Ќ�<�G�PV��G��]Q�<MD�W����dN�fsބJW��ܷ-e� \W�4�M,ayS��{0$\���.	���.�L��l>�W�Y���>�"h?�t9	��;J+V�\�R_T��d+�e�Y�ߗL|_�&P���$E8�k��E��1�Te�Ԁ	��x�2{&����<p�c�����j�z��3�[��%W*��R����o�[��e��ox�������s�\J���K ś������������ނ*��ձ{�!�cړa��������&%�o(�t��­�����UG~s��w�d&�5xQ�!����f�EanT��Ŵ�������[�d�J�?���O{^��(�ʰ�YA[V��=�`�mUXd��Ja�ޜ�f����(��O�}};:U�8�YR G�#��rn�����rY��>�qw� ��ۡ$�������f?�����%/J���t�`]	�����}^��Y_��|�Z��n�x��y�g��:�E�S���m�y�U����y��v�B�J9�Ԟ���+�pU���hVk��6������a��K�H�/�T�߮$
�3}��IQA}!�$��:�3�,����te��s�:ԯo���^�+5�Pʨ���*8PAǻ��7qhWp��#�/fkq�EYU�wVѷ����Q`O�Sj�z\��ڛ*x&�����o��i��J�;�֡��ϓ�n:z�8C�tx<���
.����V{B����+8�s��F�V�A�
^X�t5e�Z�\�=y]'��9ZZ7p�n�@���[h�ݴ�Bc-����N�l�M%�i�t]��&Bԃ���*Bg�9��j�����k���Q�/мص�
^;��Z��d�����{*��hd�z��&�B��hr�2��-����t��uZ�U�k���7q��u��۵��Nm�=G��+hl��~D���+�����I��Z�6�SJ��4%�7��H��58:t6��]D���r?��r�F=~C������m����>�Y����*���VG���o��w��PK
    )V�V            	         �A    META-INF/��  PK
   (V�VeA�|x   �              ��+   META-INF/MANIFEST.MFPK
   �U�V�<���  n             ���   Email.classPK
   ;U�V#�J\O  �             ���  EmailAccount.classPK
   �U�VP��c�  �             ��[  EmailUtils.classPK
   �R�V۴:�D  �             ��M  FileManagement.classPK
   )V�VDW|�N  �             ���  Main$1.classPK
   )V�VQB�d    
           ��;  Main.classPK      �  �                                                                                                                                                                                                                                                                                                                                APCSAFinalProject/src/                                                                              0000755 0001750 0001750 00000000000 14436125147 013450  5                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   APCSAFinalProject/src/EmailAccount.java                                                             0000644 0001750 0001750 00000005574 14440113435 016662  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailAccount implements Serializable {
  private static final long serialVersionUID = 1L;

  transient static Scanner in = new Scanner(System.in);
  
  private String name;
  private String email_address;
  private String password;

  private static int num_accounts;

  private ArrayList<Email> emails;

  public EmailAccount(String name, String username, String pw) {
    this.name = name;
    this.email_address = username;
    this.password = pw;
    emails = new ArrayList<Email>();
    EmailUtils.email_accounts.add(this);
    updateSize();
    this.receiveEmail(new Email("This is a test message to show that the email system works!", this));
  }

  public String getName() { return this.name; }
  public String getUsername() { return this.email_address; }
  public static int getNumAccounts() { return num_accounts; }

  public void setPassword(String pw) {
    this.password = pw;
  }

  public void sendEmail() {
    System.out.println("What is the username of the person you would like to send this email to?");
    EmailAccount recipient = null;
    do {
      System.out.print("Username: ");
      String recipient_user = in.nextLine();
      recipient = EmailUtils.accountExists(recipient_user);
  
      if(recipient == null) {
        System.out.println("Please enter a valid username!");
      }
    } while(recipient == null);

    System.out.println("What is the message you would like to send?");
    String message = in.nextLine();
    
    System.out.println("Ok, sending message to " + recipient.getName());
    Email email = new Email(message, this);
    recipient.receiveEmail(email);
    
    System.out.println("Sent.");
    System.out.println(email);
    
    return;
  }

  public void receiveEmail(Email e) {
    emails.add(e);
  }

  public void readEmails() {
    System.out.println("You have " + emails.size() + " email(s).");
    
    if(emails.size() == 0) return;
    int i = 1;
    for(Email email : emails) {
      System.out.println("Email #" + i + ": " + email.msgPreview() + ""); 
      i++;
    }

    while(true) {
      System.out.print("Select an email to read: ");
      
      System.out.println(
        emails.get(
          EmailUtils.getValidInt(1, (emails.size())) - 1
        )
      );

      System.out.println("\nWould you like to read another email?");
      System.out.print("Type yes, otherwise it will quit. ");
      if(!in.nextLine().equals("yes")) break;
    }
  }
  
  public boolean checkPassword(String string) {
    return string.equals(password);
  }

  public static void updateSize() {
    num_accounts = EmailUtils.email_accounts.size();
  }

  public void printInfo() {
    System.out.println("Name: " + name + 
                      "\nEmail address: " + email_address);
  }
  
  public String toString() {
    return this.email_address + "@" + EmailUtils.domain;
  }
}
                                                                                                                                    APCSAFinalProject/src/Email.java                                                                    0000644 0001750 0001750 00000001417 14440114142 015331  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   import java.io.Serializable;

public class Email implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String message;
  private EmailAccount sender;
  
  public Email(String message, EmailAccount sender) {
    this.message = message;
    this.sender = sender;
  }

  public String msgPreview() {
    String[] arr = message.split("\\s+");

    int num_words;
    if(arr.length < 3) {
      num_words = arr.length;
    } else {
      num_words = 3;
    }
    
    String preview = "";
    for(int i = 0; i < num_words; i++) {
      preview += (arr[i]) + " ";
    }
    preview += "...";
    return preview;
  }

  public String toString() {
    return 
      "From: " + sender.getName() + " (" + sender + ")" +
      "\nMessage:\n" + message;
  }
}                                                                                                                                                                                                                                                 APCSAFinalProject/src/FileManagement.java                                                           0000644 0001750 0001750 00000004465 14436122240 017167  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManagement {
    public static File createValidFile(String pathname) {
        File file = new File(pathname);
        try {
            new File(pathname.split("/")[0]).mkdirs();
            file.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return file;
    }
    
    public static void saveObjectsToFile(String filename, ArrayList<EmailAccount> arraylist) {
        if(arraylist.size() == 0) return;

        try {
            FileOutputStream file_out = new FileOutputStream(createValidFile(filename), true);
            ObjectOutputStream out = new ObjectOutputStream(file_out);
        
            for(EmailAccount e : arraylist) {
                try {
                    out.writeObject(e);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            out.close();
            file_out.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static ArrayList<EmailAccount> loadFromFile(String filename) {
        File file = new File(filename);
        if(!file.exists()) return new ArrayList<EmailAccount>();

        ArrayList<EmailAccount> arraylist = new ArrayList<>();
        try {
            FileInputStream file_in = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(file_in);
            boolean running = true;
            while(running) {
                try {
                    EmailAccount e = null;
                    try {
                        e = (EmailAccount) in.readObject();   
                    } catch (EOFException eof) { }

                    if(e != null) {
                        arraylist.add(e);
                    } else {
                        running = false;
                    }
                } catch (Exception e) { 
                    e.printStackTrace(); 
                }
            }
            file_in.close();
            in.close();
        } catch (Exception e) { e.printStackTrace(); }

        file.delete();
        return arraylist;
    }
}                                                                                                                                                                                                           APCSAFinalProject/src/EmailUtils.java                                                               0000644 0001750 0001750 00000006744 14440114071 016363  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   import java.util.ArrayList;
import java.util.Scanner;

public class EmailUtils {
  public static String domain = "evan.gov.edu";

  private static Scanner in = new Scanner(System.in);
  public static ArrayList<EmailAccount> email_accounts;
  
  public static void setup() {
    System.out.println("Welcome to the Email setup utility.");
    while(true) {
      System.out.print("Your account's username: ");
      String username = getValidUsername();

      System.out.print("Your name: ");
      String name = getValidName();

      System.out.print("Password: ");
      String password = getValidPassword();

      EmailAccount e = new EmailAccount(name, username, password);
      
      System.out.println("Your email account has been created.");
      e.printInfo();

      System.out.println("If you would like to create another account, type \'yes\'.\nOtherwise, the setup will conclude.");
      if(!in.nextLine().equals("yes")) break;
    }
    
    System.out.println("Thank you for choosing " + domain + "!");
  }

  public static void printAllEmails(ArrayList<EmailAccount> emails) {
    System.out.println("All existing emails: ");
    for(EmailAccount e : emails) {
      System.out.println("    " + e.getName() + " (" + e + ")");
    }
    System.out.println();
  }

  public static EmailAccount accountExists(String username) {
    for(EmailAccount acc : email_accounts) {
      if(acc.getUsername().equals(username.toLowerCase()))
        return acc;
    }

    return null;
  }

  public static boolean checkPassword(String pw, int it) {
    String input = in.nextLine();
    if(!input.equals(pw)) {
      if(it > 0) return false;
      
      System.out.print("Passwords do not match." + 
                       "\nOne more try: ");
      return checkPassword(pw, it+1);
    }

    return true;
  }
  
  public static int getValidInt(int from, int to) {
    String input = in.nextLine();
    int int_value = -1;
    
    try {
      int_value = Integer.parseInt(input); 
    } catch(NumberFormatException e) { }

    if((int_value >= from) && (int_value <= to)) {
      return int_value;
    }
    
    System.out.print("Please enter a number from " + from + " to " + to + ": ");
    return getValidInt(from, to);
  }

  public static String getValidName() {
    String input = in.nextLine();
    if(input.equals("") || input.equals(" ")) {
      System.out.print("Please add your name: ");
      return getValidName();
    } else {
      return input;
    }
  }

  public static String getValidPassword() {
    String input = in.nextLine();
    if(!stringHasNoSpaces(input)) {
      System.out.print("Please enter a password without spaces: ");
      return getValidPassword();
    }

    System.out.print("Confirm password: ");
    if(!checkPassword(input, 0)) {
      System.out.println("Failed to confirm, please re-enter your password: ");
      return getValidPassword();
    }
    
    return input;
  }
  
  public static String getValidUsername() {
    String input = in.nextLine();
    
    if(!stringHasNoSpaces(input)) {
      System.out.print("Please enter a valid string: ");
      return getValidUsername();
    }

    if(accountExists(input) != null) {
      System.out.print("Username already exists!\nPlease enter a new username: ");
      return getValidUsername();
    }

    return input;
  }
  
  public static boolean stringHasNoSpaces(String string) {
    for(int i = 0; i < string.length() - 1; i++) {
      if(string.substring(i, i+1).equals(" ")) {
        return false;
      }
    }

    return true;
  }
}
                            APCSAFinalProject/src/Main.java                                                                     0000644 0001750 0001750 00000006567 14440114347 015210  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   import java.util.Scanner;

class Main {
  static Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) {
    EmailUtils.email_accounts = FileManagement.loadFromFile("data/save.txt"); // loads account data from file
    EmailAccount.updateSize();
    Runtime.getRuntime().addShutdownHook(new Thread() { // saves when program quits
      public void run() {
        FileManagement.saveObjectsToFile("data/save.txt", EmailUtils.email_accounts);
      }
    });

    clearScreen();
    startmenu();
  }

  public static void startmenu() {
    System.out.println("Evan's Email \"Server\"\nWelcome to " + EmailUtils.domain + "!");
    
    while(true) { // loops main menu
      System.out.println("What would you like to do? Note that to send or read emails, you must create an account beforehand." + 
                        "\n    1. Create new account(s)" + 
                        "\n    2. Send an email" +
                        "\n    3. Read your emails" +
                        "\n    4. Check number of accounts so far" +
                        "\n    5. List all existing accounts" + 
                        "\n    6. Quit");
      final int NUM_OPTIONS = 6;

      System.out.print("Input: ");
      int select = EmailUtils.getValidInt(1, NUM_OPTIONS);

      if(select == NUM_OPTIONS) {
        System.out.println("Exiting program. Thank you for choosing " + EmailUtils.domain + ".");
        break;
      }

      clearScreen();
      EmailAccount user;
      switch(select) {
        case 1:
          EmailUtils.setup();
          break;
        case 2:
          user = login();
          if(user == null) {
            System.out.println("Failed to login. Please select again and re-login.");
          } else {
            user.sendEmail();
          }
          break;
        case 3:
          user = login();
          if(user == null) {
            System.out.println("Failed to login. Please select again and re-login.");
          } else {
            user.readEmails();
          }
          break;
        case 4:
          System.out.println("There are " + EmailAccount.getNumAccounts() + " accounts created so far.");
          break;
        case 5:
          EmailUtils.printAllEmails(EmailUtils.email_accounts);
          break;
      }
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }

  public static EmailAccount login() {
    EmailAccount e = null;
    do {
      System.out.print("Enter email username (or q to quit): ");
      String user = in.nextLine();

      if(user.equals("q")) {
        System.out.println("Exiting...");
        return null;
      }
      
      e = EmailUtils.accountExists(user);  
      if(e == null) {
        System.out.println("Please enter a valid username (if your account does not exist, please create one from the menu)!");
      }
    } while(e == null);

    if(!passwordCorrect(e)) {
      return null;
    }

    return e;
  }

  public static boolean passwordCorrect(EmailAccount e) {
    for(int i = 3; i > 0; i--) {
      System.out.println("You have " + i + " attempts remaining before the login will close.");
      System.out.print("Enter password: ");
      String pw = in.nextLine();

      if(e.checkPassword(pw)) {
        return true;
      } else {
        System.out.print("Incorrect password! ");
      }
    }
    System.out.println();
    return false;
  }
}
                                                                                                                                         APCSAFinalProject/start.sh                                                                          0000755 0001750 0001750 00000000264 14437636207 014364  0                                                                                                    ustar   evan                            evan                                                                                                                                                                                                                   #!/bin/bash

compile () {
    ant package
}

if [ ! -d "dist/" ]
then
    compile
fi

if [ "$1" = "--compile" ] 
then
    compile
fi

cd dist/
java -jar APCSAFinalProject.jar
cd ..                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            