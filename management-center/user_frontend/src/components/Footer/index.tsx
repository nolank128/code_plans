import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import {PLANET_LINK} from "@/constants";

const Footer: React.FC = () => {
  const defaultMessage = '测试';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'planet',
          title: '微信公众号',
          href: PLANET_LINK,
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/Ktrol',
          blankTarget: true,
        },
        {
          key: '测试',
          title: '测试',
          href: 'https://github.com/Ktrol',
          blankTarget: true,
        },
        ]}
    />
  );
};
export default Footer;
